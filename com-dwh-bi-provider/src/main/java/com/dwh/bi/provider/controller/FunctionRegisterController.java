package com.dwh.bi.provider.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dwh.bi.base.params.RequestObject;
import com.dwh.bi.base.vo.ResultObject;

import com.dwh.bi.common.domain.FunctionRegister;
import com.dwh.bi.common.params.FunctionPageParam;
import com.dwh.bi.common.service.impl.FunctionRegisterServiceImpl;
import com.dwh.bi.common.vo.FunctionRegisterVO;
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
@Tag(name = "功能注册管理",description = "功能注册管理")
@RestController
@RequestMapping("/api/function-register")
public class FunctionRegisterController {

    private final FunctionRegisterServiceImpl functionRegisterService ;

    public FunctionRegisterController(FunctionRegisterServiceImpl functionRegisterService) {
        this.functionRegisterService = functionRegisterService;
    }

    @Operation(description = "saveOrUpdate",summary = "增加或更新一个功能")
    @Parameters(@Parameter(name = "param" ,description = "数据源",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = RequestObject.class))}))
    @ApiResponses(@ApiResponse(responseCode = "200",description = "成功",content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResultObject.class))} ))
    @PostMapping("saveOrUpdate")
    public ResultObject<Boolean> saveOrUpdate(@Valid @RequestBody RequestObject<FunctionRegisterVO> param){
        return ResultObject.success(functionRegisterService.saveOrUpdate(BeanUtil.copyProperties(param.getParams(),FunctionRegister.class)));
    }

    @Operation(description = "removeById",summary = "根据主键删除指定功能")
    @Parameters(@Parameter(name = "id",description = "主键",content = {@Content(mediaType = "plain/text",schema = @Schema(implementation = String.class))}))
    @ApiResponses(@ApiResponse(responseCode = "200",description = "成功",content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResultObject.class))} ))
    @DeleteMapping("removeById")
    public ResultObject<Boolean> removeById(@RequestParam("id")String id){
        return  ResultObject.success(functionRegisterService.removeById(id));
    }

    @Operation(description = "page",summary = "分页查询数功能列表")
    @PostMapping("page")
    ResultObject<IPage<FunctionRegisterVO>> page(@Valid @RequestBody RequestObject<FunctionPageParam> param){
        return ResultObject.success(functionRegisterService.page(param.getParams()));
    }
}
