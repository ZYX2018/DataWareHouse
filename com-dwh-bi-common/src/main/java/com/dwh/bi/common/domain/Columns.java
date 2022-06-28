package com.dwh.bi.common.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 列
 * @author zhangyx-v
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("COLUMNS")
public class Columns {

    @TableField("COLUMN_NAME")
    private String columnName;
    @TableField("DATA_TYPE")
    private String dataType;
    @TableField("COLUMN_COMMENT")
    private String columnCommit;
    @TableField("TABLE_NAME")
    private String tableName;

    @TableField("TABLE_SCHEMA")
    private String schemaName;

}
