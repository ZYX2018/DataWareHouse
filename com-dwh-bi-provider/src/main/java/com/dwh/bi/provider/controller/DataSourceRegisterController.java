package com.dwh.bi.provider.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.http.HttpStatus;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.creator.DefaultDataSourceCreator;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dwh.bi.base.params.RequestObject;
import com.dwh.bi.base.vo.ResultObject;

import com.dwh.bi.common.domain.DataSourceRegister;
import com.dwh.bi.common.dto.DataSourceDTO;
import com.dwh.bi.common.params.DataSourcePageParam;
import com.dwh.bi.common.service.impl.DataSourceRegisterServiceImpl;
import com.dwh.bi.common.vo.DataSourceRegisterVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import javax.validation.Valid;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Set;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhangyx-v
 * @since 2022-06-18
 */
@Tag(name = "数据源管理",description = "数据源管理")
@RestController
@RequestMapping("/api/data-source-register/")
@Slf4j
public class DataSourceRegisterController {


    private  final String DRIVER_CLASS_NAME ;
    private final DataSourceRegisterServiceImpl dataSourceRegisterService ;
    private final DataSource dynamicRoutingDataSource;
    private final DefaultDataSourceCreator dataSourceCreator;

    public DataSourceRegisterController(@Value("${ds.datasource.driver-class-name}")String driverClassName, DataSourceRegisterServiceImpl dataSourceRegisterService, DataSource dynamicRoutingDataSource, DefaultDataSourceCreator dataSourceCreator) {
        DRIVER_CLASS_NAME = driverClassName;
        this.dataSourceRegisterService = dataSourceRegisterService;
        this.dynamicRoutingDataSource = dynamicRoutingDataSource;
        this.dataSourceCreator = dataSourceCreator;
    }

    @PostConstruct
    public void init(){
        List<DataSourceRegister> dataSourceRegisterList = dataSourceRegisterService.list();
        dataSourceRegisterList.forEach(source->{
            log.info("初始化数据源:{}", JSONObject.toJSONString(source));
            try {
                insertDataSource(source);
            }catch (Exception e){
                String url ="jdbc:mysql://"+source.getSourceIp()+":"+source.getSourcePort()+"/"+source.getSourceName();
                log.error("初始化数据源:{}失败,原因：{}", url,e.getMessage());
            }
        });
        DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dynamicRoutingDataSource;
        log.info("数据源初始化完毕->数据源：{}",ds.getDataSources().keySet());
    }
    private Set<String> insertDataSource(DataSourceRegister dataSourceRegister){
        String url ="jdbc:mysql://"+dataSourceRegister.getSourceIp()+":"+dataSourceRegister.getSourcePort()+"/"+dataSourceRegister.getSourceName()+"?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&serverTimezone=GMT%2B8";
        DataSourceDTO dataSourceDTO = new DataSourceDTO();
        dataSourceDTO.setPassword(dataSourceRegister.getUserPassword());
        dataSourceDTO.setUsername(dataSourceRegister.getUserName());
        dataSourceDTO.setUrl(url);
        dataSourceDTO.setPoolName(dataSourceRegister.getId());
        dataSourceDTO.setDriverClassName("com.mysql.cj.jdbc.Driver");
        DataSourceProperty dataSourceProperty = BeanUtil.copyProperties(dataSourceDTO,DataSourceProperty.class);
        DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dynamicRoutingDataSource;
        DataSource dataSource = dataSourceCreator.createDataSource(dataSourceProperty);
        ds.addDataSource(dataSourceDTO.getPoolName(), dataSource);
        return ds.getDataSources().keySet();
    }
    @Operation(description = "增加一个数据源",summary = "增加一个数据源")
    @Parameters(@Parameter(name = "param" ,description = "数据源",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = RequestObject.class))}))
    @ApiResponses(@ApiResponse(responseCode = "200",description = "成功",content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResultObject.class))} ))
    @PostMapping("add")
    ResultObject saveOrUpdate(@Valid @RequestBody RequestObject<DataSourceRegisterVO> param){
        DataSourceRegister register = BeanUtil.copyProperties(param.getParams(),DataSourceRegister.class);
        boolean success = dataSourceRegisterService.saveOrUpdate(register);
        if (!success){
            return ResultObject.fail("增加数据源失败", HttpStatus.HTTP_INTERNAL_ERROR);
        }
        try {
            return ResultObject.success(insertDataSource(register));
        }catch (Exception e){
            return ResultObject.fail("增加数据源失败,原因："+e.getMessage(), HttpStatus.HTTP_INTERNAL_ERROR);
        }
    }

    @Operation(description = "删除一个数据源",summary = "removeDataSourceById")
    @Parameters(@Parameter(name = "dataSourceId",description = "数据源主键",content = {@Content(mediaType = "plain/text",schema = @Schema(implementation = String.class))}))
    @ApiResponses(@ApiResponse(responseCode = "200",description = "成功",content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResultObject.class))} ))
    @DeleteMapping("remove-by-id")
    ResultObject<Boolean> remove(@RequestParam("dataSourceId")String dataSourceId){
        DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dynamicRoutingDataSource;
        ds.removeDataSource(dataSourceId);
        return ResultObject.success(dataSourceRegisterService.removeById(dataSourceId));
    }

    @Operation(description = "分页查询数据源",summary = "getDataSourcePage")
    @Parameters(@Parameter(name = "param",description = "数据分页查询参数",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = RequestObject.class))}))
    @ApiResponses(@ApiResponse(responseCode = "200",description = "成功",content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResultObject.class))} ))
    @PostMapping("page")
    ResultObject<IPage<DataSourceRegister>> getDataSourcePage(@Valid @RequestBody RequestObject<DataSourcePageParam> param){
        return ResultObject.success(dataSourceRegisterService.page(param.getParams()));
    }
    @Parameters(@Parameter(name = "param" ,description = "数据源",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = RequestObject.class))}))
    @ApiResponses(@ApiResponse(responseCode = "200",description = "mysql链接测试结果",content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResultObject.class))} ))
    @Operation(description = "mysql链接测试",summary = "mysql链接测试")
    @GetMapping("/link-testing")
    public ResultObject<String> testConnection(@io.swagger.v3.oas.annotations.parameters.RequestBody DataSourceRegisterVO  source){
        String url="";
        Connection con;
        try {
            url ="jdbc:mysql://"+source.getSourceIp()+":"+source.getSourcePort()+"/"+source.getSourceName();
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection(url, source.getUserName(), source.getUserPassword());
        } catch (Exception e) {
            return ResultObject.fail("链接失败"+e.getMessage(), HttpStatus.HTTP_BAD_REQUEST);
        }
        return ResultObject.success("链接成功 ："+ url);
    }
}
