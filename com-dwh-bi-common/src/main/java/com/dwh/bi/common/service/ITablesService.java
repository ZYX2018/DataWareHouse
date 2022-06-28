package com.dwh.bi.common.service;

import com.dwh.bi.common.domain.Tables;
import com.github.yulichang.base.MPJBaseService;

import java.util.List;

/**
 * @author zhangyx-v
 */
public interface ITablesService extends MPJBaseService<Tables> {

    /**
     * listTables
     * @param schemaName schemaName
     * @return Tables
     */
    List<Tables> listTables(String schemaName);

}
