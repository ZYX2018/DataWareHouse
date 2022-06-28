package com.dwh.bi.common.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.http.HttpStatus;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.creator.DefaultDataSourceCreator;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dwh.bi.base.constants.DsDataSourceConstants;
import com.dwh.bi.base.vo.ResultObject;
import com.dwh.bi.common.builder.DataSourceDTOBuiler;
import com.dwh.bi.common.domain.DataSourceRegister;
import com.dwh.bi.common.dto.DataSourceDTO;
import com.dwh.bi.common.mapper.DataSourceRegisterMapper;
import com.dwh.bi.common.params.DataSourcePageParam;
import com.dwh.bi.common.service.IDataSourceRegisterService;
import com.dwh.bi.common.vo.DataSourceRegisterVO;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangyx-v
 * @since 2022-06-19
 */
@Slf4j
@Service
public class DataSourceRegisterServiceImpl extends MPJBaseServiceImpl<DataSourceRegisterMapper, DataSourceRegister> implements IDataSourceRegisterService {

    private final DataSourceRegisterMapper dataSourceRegisterMapper;
    private final DynamicRoutingDataSource dynamicRoutingDataSource;
    private final DefaultDataSourceCreator dataSourceCreator;
    public DataSourceRegisterServiceImpl(DataSourceRegisterMapper dataSourceRegisterMapper, DynamicRoutingDataSource dynamicRoutingDataSource, DefaultDataSourceCreator dataSourceCreator) {
        this.dataSourceRegisterMapper = dataSourceRegisterMapper;
        this.dynamicRoutingDataSource = dynamicRoutingDataSource;
        this.dataSourceCreator = dataSourceCreator;
    }

    @PostConstruct
    public void init(){
        List<DataSourceRegister> dataSourceRegisterList = list();
        dataSourceRegisterList.forEach(source->{
            log.info("初始化数据源:{}", JSONObject.toJSONString(source));
            try {
                insertDataSource(source);
            }catch (Exception e){
                String url ="jdbc:mysql://"+source.getSourceIp()+":"+source.getSourcePort()+"/"+source.getSourceName();
                log.error("初始化数据源:{}失败,原因：{}", url,e.getMessage());
            }
        });
        DynamicRoutingDataSource ds = dynamicRoutingDataSource;
        log.info("数据源初始化完毕->数据源：{}",ds.getDataSources().keySet());
    }
    @Override
    public IPage<DataSourceRegisterVO> page(DataSourcePageParam pageParamParam) {
        MPJLambdaWrapper<DataSourceRegisterVO> wrapper =   new MPJLambdaWrapper<DataSourceRegisterVO>()
                .selectAll(DataSourceRegister.class);
        if (StringUtils.isNotEmpty(pageParamParam.getIp())) {
            wrapper = wrapper.like(DataSourceRegister::getSourceIp,pageParamParam.getIp());
        }
        if (StringUtils.isNotEmpty(pageParamParam.getDataSourceName())){
            wrapper = wrapper.like(DataSourceRegister::getSourceName,pageParamParam.getDataSourceName());
        }
        wrapper = wrapper.ne(DataSourceRegister::getSourceName,DsDataSourceConstants.MYSQL_INFORMATION_DB);
        return dataSourceRegisterMapper.selectJoinPage(new Page<>(pageParamParam.getPage(),pageParamParam.getPageSize()),DataSourceRegisterVO.class,wrapper);
    }

    @Override
    public DataSourceRegister getOneRegister(String ip, String port, String dbName) {
        LambdaQueryWrapper<DataSourceRegister> wrapper = new LambdaQueryWrapper<DataSourceRegister>().eq(DataSourceRegister::getSourceIp,ip).eq(DataSourceRegister::getSourcePort,port).eq(DataSourceRegister::getSourceName,dbName);
        return  dataSourceRegisterMapper.selectOne(wrapper);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public ResultObject saveOrUpdateDsDataSource(DataSourceRegisterVO registerVO) {
        try {
            DataSourceRegister register = getOneRegister(registerVO.getSourceIp(),registerVO.getSourcePort(), registerVO.getSourceName());
            DataSourceRegister dbConstruction = getOneRegister(registerVO.getSourceIp(),registerVO.getSourcePort(), DsDataSourceConstants.MYSQL_INFORMATION_DB);
            //移除旧数据源
            if (!Objects.isNull(dbConstruction)){
                dynamicRoutingDataSource.removeDataSource(Long.toString(dbConstruction.getId()));
            }
            if (!Objects.isNull(register)){
                dynamicRoutingDataSource.removeDataSource(Long.toString(register.getId()));
            }
            //保存或更新数据源
            dbConstruction = BeanUtil.copyProperties(registerVO,DataSourceRegister.class);
            dbConstruction.setSourceName(DsDataSourceConstants.MYSQL_INFORMATION_DB);
            dbConstruction.setInformationId(Long.MIN_VALUE);
            saveOrUpdate(dbConstruction);
            register = BeanUtil.copyProperties(registerVO,DataSourceRegister.class);
            register.setInformationId(dbConstruction.getId());
            boolean success = saveOrUpdate(register);
            //初始化数据源
            if (!success){
                return ResultObject.fail("增加数据源失败", HttpStatus.HTTP_INTERNAL_ERROR);
            }
            insertDataSource(dbConstruction);
            return ResultObject.success(insertDataSource(register));
        }catch (Exception e){
            return ResultObject.fail("增加数据源失败,原因："+e.getMessage(), HttpStatus.HTTP_INTERNAL_ERROR);
        }
    }

    @Override
    public ResultObject removeDsDataSource(String dataSourceId) {
        dynamicRoutingDataSource.removeDataSource(dataSourceId);
        return  ResultObject.success(removeById(dataSourceId));
    }

    private Set<String> insertDataSource(DataSourceRegister dataSourceRegister){
        DataSourceDTO dataSourceDTO = DataSourceDTOBuiler.builder().build(dataSourceRegister);
        DataSourceProperty dataSourceProperty = BeanUtil.copyProperties(dataSourceDTO,DataSourceProperty.class);
        DynamicRoutingDataSource ds =  dynamicRoutingDataSource;
        DataSource dataSource = dataSourceCreator.createDataSource(dataSourceProperty);
        ds.addDataSource(dataSourceDTO.getPoolName(), dataSource);
        return ds.getDataSources().keySet();
    }

}
