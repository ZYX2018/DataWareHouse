package com.dwh.bi.common.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dwh.bi.common.domain.Columns;
import com.dwh.bi.common.mapper.ColumnsMapper;
import com.dwh.bi.common.service.IColumnsService;
import com.github.yulichang.base.MPJBaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangyx-v
 */
@Service
public class ColumnsServiceImpl   extends MPJBaseServiceImpl<ColumnsMapper, Columns> implements IColumnsService {

    @DS("#header.tenantName")
    @Override
    public List<Columns> listColumns(String dbName,String tableName) {
        LambdaQueryWrapper<Columns> queryWrapper = new LambdaQueryWrapper<Columns>().eq(Columns::getSchemaName,dbName).eq(Columns::getTableName,tableName);
        return list(queryWrapper);
    }
}
