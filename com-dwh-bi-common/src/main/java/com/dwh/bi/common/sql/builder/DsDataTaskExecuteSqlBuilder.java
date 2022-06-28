package com.dwh.bi.common.sql.builder;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dwh.bi.common.params.DsDataTaskExecuteParam;
import org.apache.ibatis.jdbc.SQL;

/**
 * sql builder
 * @author moon
 */
public class DsDataTaskExecuteSqlBuilder {

    public String pageSql(Page page, DsDataTaskExecuteParam param){
        return new SQL(){
            {
                SELECT("*").FROM(param.getTableName()).OFFSET(param.getPage()-1).LIMIT(param.getPageSize());
            }
        }.toString();
    }
    public String listSql(Page page, DsDataTaskExecuteParam param){
        return new SQL(){
            {
                SELECT("*").FROM(param.getTableName());
            }
        }.toString();
    }
}
