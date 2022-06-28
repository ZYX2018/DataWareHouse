package com.dwh.bi.provider.controller;

import cn.hutool.http.HttpStatus;
import com.dwh.bi.base.vo.ResultObject;
import com.dwh.bi.common.domain.DataSourceRegister;
import com.dwh.bi.common.params.ColumnsParam;
import com.dwh.bi.common.params.TablesParam;
import com.dwh.bi.common.service.impl.ColumnsServiceImpl;
import com.dwh.bi.common.service.impl.DataSourceRegisterServiceImpl;
import com.dwh.bi.common.service.impl.TablesServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author zhangyx-v
 */
@Tag(name = "数据库结构管理",description = "数据库结构管理")
@RestController
@RequestMapping("/api/db-structs/")
@Slf4j
public class DBStructsController {
    private final ColumnsServiceImpl columnsService;
    private final DataSourceRegisterServiceImpl dataSourceRegisterService;
    private final TablesServiceImpl tablesService;

    public DBStructsController(ColumnsServiceImpl columnsService, DataSourceRegisterServiceImpl dataSourceRegisterService, TablesServiceImpl tablesService) {
        this.columnsService = columnsService;
        this.dataSourceRegisterService = dataSourceRegisterService;
        this.tablesService = tablesService;
    }

    @Operation(description = "columns",summary = "根据表名查询列信息")
        @PostMapping("/columns")
    public ResultObject columns (@RequestBody ColumnsParam param){
        DataSourceRegister register = dataSourceRegisterService.getById(param.getSourceId());
        return Objects.isNull(register)?ResultObject.fail("不存在该数据源", HttpStatus.HTTP_BAD_REQUEST):ResultObject.success(columnsService.listColumns(register.getSourceName(),param.getTableName()));
    }

    @Operation(description = "tables",summary = "根据数据源主键查询表信息")
    @PostMapping("/tables")
    public ResultObject tables (@RequestBody TablesParam param){
        DataSourceRegister register = dataSourceRegisterService.getById(param.getSourceId());
        return Objects.isNull(register)?ResultObject.fail("不存在该数据源", HttpStatus.HTTP_BAD_REQUEST):ResultObject.success(tablesService.listTables(register.getSourceName()));
    }
}
