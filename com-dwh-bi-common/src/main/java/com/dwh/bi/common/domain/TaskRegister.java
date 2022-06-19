package com.dwh.bi.common.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dwh.bi.base.domain.BaseDomain;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhangyx-v
 * @since 2022-06-19
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("TASK_REGISTER")
public class TaskRegister extends BaseDomain<TaskRegister> implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("TASK_NAME")
    private String taskName;

    @TableField("TASK_CODE")
    private String taskCode;

    @TableField("SYSTEM_ID")
    private String systemId;

    @TableField("FUNCTION_ID")
    private String functionId;

    @TableField("SOURCE_ID")
    private String sourceId;

    @TableField("SOURCE_TABLE")
    private String sourceTable;

    @TableField("REMARK")
    private String remark;




}
