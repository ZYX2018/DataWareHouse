package com.dwh.bi.common.mapper;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dwh.bi.common.params.DsDataRetrieveTaskExecuteParam;
import com.dwh.bi.common.params.DsDataUpdateTaskExecuteParam;
import com.dwh.bi.common.sql.builder.DsDataTaskExecuteSqlBuilder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;


/**
 * @author moon
 */
@Mapper
public interface DsDataTaskExecuteMapper extends BaseMapper<JSONObject> {

    /**
     * IPage
     * @param param DsDataTaskExecuteParam
     * @param page page
     * @return JSONObject
     */
    @SelectProvider(type = DsDataTaskExecuteSqlBuilder.class , method = "listSql")
    @ResultType(JSONObject.class)
    @DS("#header.tenantName")
    IPage<JSONObject> page(Page page, DsDataRetrieveTaskExecuteParam param);

    /**
     *update
     * @param param DsDataUpdateTaskExecuteParam
     * @return JSONObject
     */
    @SelectProvider(type = DsDataTaskExecuteSqlBuilder.class , method = "updateSql")
    @ResultType(JSONObject.class)
    @DS("#header.tenantName")
    JSONObject update(DsDataUpdateTaskExecuteParam param);
}
