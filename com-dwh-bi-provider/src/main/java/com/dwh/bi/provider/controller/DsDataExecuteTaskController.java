package com.dwh.bi.provider.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dwh.bi.base.vo.ResultObject;
import com.dwh.bi.common.params.DsDataTaskExecuteParam;
import com.dwh.bi.common.service.impl.DsDataTaskExecuteServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author moon
 */
@RestController
@RequestMapping("/api/v1/dsTask")
@Tag(name = "数据可视化执行接口",description = "数据可视化执行接口")
@Slf4j
public class DsDataExecuteTaskController {

   private final   DsDataTaskExecuteServiceImpl dsDataTaskExecuteService;



    public DsDataExecuteTaskController(DsDataTaskExecuteServiceImpl dsDataTaskExecuteService) {
        this.dsDataTaskExecuteService = dsDataTaskExecuteService;
    }

    @Operation(description = "page",summary = "根据表名分页查询")
    @PostMapping("/page")
    public ResultObject page(@RequestBody DsDataTaskExecuteParam executeParam){
            return ResultObject.success(dsDataTaskExecuteService.getBaseMapper().page(new Page<>(executeParam.getPage(),executeParam.getPageSize()),executeParam));
    }
}
