package com.dwh.bi.provider.controller;

import cn.hutool.http.HttpStatus;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dwh.bi.base.params.RequestObject;
import com.dwh.bi.base.vo.ResultObject;

import com.dwh.bi.common.domain.DataSourceRegister;
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
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Connection;
import java.sql.DriverManager;

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


    private final DataSourceRegisterServiceImpl dataSourceRegisterService ;

    public DataSourceRegisterController(DataSourceRegisterServiceImpl dataSourceRegisterService) {
        this.dataSourceRegisterService = dataSourceRegisterService;
    }


    @Operation(description = "增加一个数据源",summary = "增加一个数据源")
    @Parameters(@Parameter(name = "param" ,description = "数据源",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = RequestObject.class))}))
    @ApiResponses(@ApiResponse(responseCode = "200",description = "成功",content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResultObject.class))} ))
    @PostMapping("add")
    ResultObject saveOrUpdate(@Valid @RequestBody RequestObject<DataSourceRegisterVO> param){
        return dataSourceRegisterService.saveOrUpdateDsDataSource(param.getParams());
    }

    @Operation(description = "删除一个数据源",summary = "removeDataSourceById")
    @Parameters(@Parameter(name = "dataSourceId",description = "数据源主键",content = {@Content(mediaType = "plain/text",schema = @Schema(implementation = String.class))}))
    @ApiResponses(@ApiResponse(responseCode = "200",description = "成功",content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResultObject.class))} ))
    @DeleteMapping("remove-by-id")
    ResultObject<Boolean> remove(@RequestParam("dataSourceId")String dataSourceId){
        return dataSourceRegisterService.removeDsDataSource(dataSourceId);
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
    @PostMapping("/link-testing")
    public ResultObject<String> testConnection(@RequestBody DataSourceRegisterVO  source){
        String url="";
        Connection con;
        try {
            url = "jdbc:mysql://"+source.getSourceIp()+":"+source.getSourcePort();
            if (StringUtils.isNotBlank(source.getSourceName())){
                url = url +"/"+source.getSourceName();
            }
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection(url, source.getUserName(), source.getUserPassword());
        } catch (Exception e) {
            return ResultObject.fail("链接失败"+e.getMessage(), HttpStatus.HTTP_BAD_REQUEST);
        }
        return ResultObject.success("链接成功 ："+ url);
    }
}
