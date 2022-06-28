package com.dwh.bi.common.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dwh.bi.common.domain.Tables;
import com.dwh.bi.common.mapper.TablesMapper;
import com.dwh.bi.common.service.ITablesService;
import com.github.yulichang.base.MPJBaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangyx-v
 */
@Service
public class TablesServiceImpl extends MPJBaseServiceImpl<TablesMapper, Tables> implements ITablesService {
    @DS("#header.tenantName")
    @Override
    public List<Tables> listTables(String schemaName) {
        LambdaQueryWrapper<Tables> queryWrapper = new LambdaQueryWrapper<Tables>().eq(Tables::getSchemaName,schemaName);
        return list(queryWrapper);
    }
}
