package com.dwh.bi.provider.controller;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dwh.bi.base.vo.ResultObject;
import com.dwh.bi.common.domain.TaskRegister;
import com.dwh.bi.common.params.DsDataRetrieveTaskExecuteParam;
import com.dwh.bi.common.params.DsDataUpdateTaskExecuteParam;
import com.dwh.bi.common.service.impl.DsDataTaskExecuteServiceImpl;
import com.dwh.bi.common.service.impl.TaskRegisterServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author moon
 */
@RestController
@RequestMapping("/api/v1/dsTask")
@Tag(name = "数据可视化执行接口",description = "数据可视化执行接口")
@Slf4j
public class DsDataExecuteTaskController {

   private final  DsDataTaskExecuteServiceImpl dsDataTaskExecuteService;

   private final TaskRegisterServiceImpl taskRegisterService;



    public DsDataExecuteTaskController(DsDataTaskExecuteServiceImpl dsDataTaskExecuteService, TaskRegisterServiceImpl taskRegisterService) {
        this.dsDataTaskExecuteService = dsDataTaskExecuteService;
        this.taskRegisterService = taskRegisterService;
    }

    @Operation(description = "page",summary = "根据表名分页查询")
    @PostMapping("/page")
    public ResultObject<IPage<JSONObject>> page(@Valid @RequestBody DsDataRetrieveTaskExecuteParam executeParam){
        TaskRegister taskRegister = taskRegisterService.getById(executeParam.getTaskId());
        executeParam.setTaskId(taskRegister.getSourceTable());
        IPage<JSONObject> resPage =dsDataTaskExecuteService.getBaseMapper().page(new Page<>(executeParam.getPage(),executeParam.getPageSize()),executeParam);
        return ResultObject.success(resPage);
    }

    @Operation(description = "update",summary = "执行更新语句")
    @PostMapping("/update")
    public ResultObject<JSONObject> update(@Valid @RequestBody DsDataUpdateTaskExecuteParam executeParam){
        TaskRegister taskRegister = taskRegisterService.getById(executeParam.getTaskId());
        executeParam.setTaskId(taskRegister.getSourceTable());
        JSONObject resPage =dsDataTaskExecuteService.getBaseMapper().update(executeParam);
        return ResultObject.success(resPage);
    }

}
