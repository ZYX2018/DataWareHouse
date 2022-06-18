package com.dwh.bi.provider.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dwh.bi.base.params.RequestObject;
import com.dwh.bi.base.vo.ResultObject;
import com.dwh.bi.common.domain.FunctionRegister;
import com.dwh.bi.common.domain.SystemRegister;
import com.dwh.bi.common.params.SystemPageParam;
import com.dwh.bi.common.service.impl.SystemRegisterServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhangyx-v
 * @since 2022-06-18
 */
@Tag(name = "系统注册管理",description = "系统注册管理")
@RestController
@RequestMapping("/api/system-register")
public class SystemRegisterController {

    private final SystemRegisterServiceImpl systemRegisterService;

    public SystemRegisterController(SystemRegisterServiceImpl systemRegisterService) {
        this.systemRegisterService = systemRegisterService;
    }


    @Operation(description = "增加或更新一个系统",summary = "saveOrUpdate")
    @Parameters(@Parameter(name = "param" ,description = "数据源",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = RequestObject.class))}))
    @ApiResponses(@ApiResponse(responseCode = "200",description = "成功",content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResultObject.class))} ))
    @PostMapping("saveOrUpdate")
    public ResultObject<Boolean> saveOrUpdate(@Valid @RequestBody RequestObject<SystemRegister> param){
        return ResultObject.success(systemRegisterService.saveOrUpdate(param.getParams()));
    }

    @Operation(description = "根据主键删除",summary = "removeById")
    @Parameters(@Parameter(name = "id",description = "主键",content = {@Content(mediaType = "plain/text",schema = @Schema(implementation = String.class))}))
    @ApiResponses(@ApiResponse(responseCode = "200",description = "成功",content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResultObject.class))} ))
    @DeleteMapping("removeById")
    public ResultObject<Boolean> removeById(@RequestParam("id")String id){
        return  ResultObject.success(systemRegisterService.removeById(id));
    }

    @Operation(description = "分页查询",summary = "page")
    @Parameters(@Parameter(name = "param",description = "数据分页查询参数",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = RequestObject.class))}))
    @ApiResponses(@ApiResponse(responseCode = "200",description = "成功",content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResultObject.class))} ))
    @PostMapping("page")
    ResultObject<Page<FunctionRegister>> page(@Valid @RequestBody RequestObject<SystemPageParam> param){
        return ResultObject.success(systemRegisterService.lambdaQuery().like(SystemRegister::getSystemName,param.getParams().getName()).like(SystemRegister::getSystemIp,param.getParams().getIp()).page(new Page<>(param.getParams().getPage(),param.getParams().getPageSize())) );
    }
}
