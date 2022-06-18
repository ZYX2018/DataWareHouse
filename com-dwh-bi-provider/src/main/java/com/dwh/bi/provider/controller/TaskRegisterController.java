package com.dwh.bi.provider.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dwh.bi.base.params.RequestObject;
import com.dwh.bi.base.vo.ResultObject;
import com.dwh.bi.common.domain.FunctionRegister;
import com.dwh.bi.common.domain.TaskRegister;

import com.dwh.bi.common.service.impl.TaskRegisterServiceImpl;
import com.dwh.bi.common.vo.TaskPageParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
@RestController
@RequestMapping("/api/task-register")
public class TaskRegisterController {

    private final TaskRegisterServiceImpl taskRegisterService ;

    public TaskRegisterController(TaskRegisterServiceImpl taskRegisterService) {
        this.taskRegisterService = taskRegisterService;
    }


    @Operation(description = "增加或更新一个任务",summary = "saveOrUpdate")
    @Parameters(@Parameter(name = "param" ,description = "数据源",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = RequestObject.class))}))
    @ApiResponses(@ApiResponse(responseCode = "200",description = "成功",content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResultObject.class))} ))
    @PostMapping("saveOrUpdate")
    public ResultObject<Boolean> saveOrUpdate(@Valid @RequestBody RequestObject<TaskRegister> param){
        return ResultObject.success(taskRegisterService.saveOrUpdate(param.getParams()));
    }

    @Operation(description = "根据主键删除",summary = "removeById")
    @Parameters(@Parameter(name = "id",description = "主键",content = {@Content(mediaType = "plain/text",schema = @Schema(implementation = String.class))}))
    @ApiResponses(@ApiResponse(responseCode = "200",description = "成功",content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResultObject.class))} ))
    @DeleteMapping("removeById")
    public ResultObject<Boolean> removeById(@RequestParam("id")String id){
        return  ResultObject.success(taskRegisterService.removeById(id));
    }

    @Operation(description = "分页查询",summary = "page")
    @Parameters(@Parameter(name = "param",description = "数据分页查询参数",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = RequestObject.class))}))
    @ApiResponses(@ApiResponse(responseCode = "200",description = "成功",content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResultObject.class))} ))
    @PostMapping("page")
    ResultObject<Page<FunctionRegister>> page(@Valid @RequestBody RequestObject<TaskPageParam> param){
        return null;
    }
}
