package com.dwh.bi.common.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dwh.bi.common.domain.DataSourceRegister;
import com.dwh.bi.common.mapper.DataSourceRegisterMapper;
import com.dwh.bi.common.params.DataSourcePageParam;
import com.dwh.bi.common.service.IDataSourceRegisterService;
import com.dwh.bi.common.vo.DataSourceRegisterVO;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangyx-v
 * @since 2022-06-19
 */
@Service
public class DataSourceRegisterServiceImpl extends MPJBaseServiceImpl<DataSourceRegisterMapper, DataSourceRegister> implements IDataSourceRegisterService {

    private final DataSourceRegisterMapper dataSourceRegisterMapper;

    public DataSourceRegisterServiceImpl(DataSourceRegisterMapper dataSourceRegisterMapper) {
        this.dataSourceRegisterMapper = dataSourceRegisterMapper;
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
        return dataSourceRegisterMapper.selectJoinPage(new Page<>(pageParamParam.getPage(),pageParamParam.getPageSize()),DataSourceRegisterVO.class,wrapper);
    }


}
