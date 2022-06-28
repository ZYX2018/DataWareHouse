package com.dwh.bi.common.service;

import com.dwh.bi.common.domain.Columns;
import com.github.yulichang.base.MPJBaseService;

import java.util.List;

/**
 * @author zhangyx-v
 */
public interface IColumnsService extends MPJBaseService<Columns> {

    /**
     *  Columns
     * @param tableName tableName
     * @return List
     */
    List<Columns> listColumns(String dbName , String tableName);
}
