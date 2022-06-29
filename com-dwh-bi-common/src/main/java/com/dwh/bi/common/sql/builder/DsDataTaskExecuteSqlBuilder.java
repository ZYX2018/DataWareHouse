package com.dwh.bi.common.sql.builder;
import cn.hutool.core.util.ArrayUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dwh.bi.common.params.DsDataRetrieveTaskExecuteParam;
import com.dwh.bi.common.params.DsDataUpdateTaskExecuteParam;
import org.apache.ibatis.jdbc.SQL;

/**
 * sql builder
 * @author moon
 */
public class DsDataTaskExecuteSqlBuilder {


    public String listSql(Page page, DsDataRetrieveTaskExecuteParam param){
        return new SQL(){
            {
                String selectColumns = ArrayUtil.isEmpty(param.getColumns()) ? "*" : ArrayUtil.join(param.getColumns(),",");
                SELECT(selectColumns).FROM(param.getTaskId());
                param.getWhere().ifPresent(this::WHERE);
            }
        }.toString();
    }

    public String updateSql(DsDataUpdateTaskExecuteParam updateTaskExecuteParam){
        return new SQL(){
            {
                UPDATE(updateTaskExecuteParam.getTaskId());
                updateTaskExecuteParam.getUpdateColumns().forEach((k,v)->SET(k+"="+"'"+v+"'"));
                WHERE(updateTaskExecuteParam.getWhere());
            }
        }.toString();
    }
}
