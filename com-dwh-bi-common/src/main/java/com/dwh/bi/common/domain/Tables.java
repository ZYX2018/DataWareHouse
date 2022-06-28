package com.dwh.bi.common.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author zhangyx-v
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("TABLES")
public class Tables {

    @TableField("TABLE_NAME")
    private String tableName;
    @TableField("TABLE_SCHEMA")
    private String schemaName;
    @TableField("TABLE_COMMENT")
    private String tableCommit;
}
