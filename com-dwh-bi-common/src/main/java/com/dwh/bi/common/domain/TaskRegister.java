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
@Schema(name  = "TaskRegister对象", description = "任务注册")
public class TaskRegister extends BaseDomain<TaskRegister> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description ="任务名称")
    @TableField("TASK_NAME")
    private String taskName;

    @Schema(description ="任务编码")
    @TableField("TASK_CODE")
    private String taskCode;

    @Schema(description ="服务IP")
    @TableField("SYSTEM_ID")
    private String systemId;

    @Schema(description ="功能主键")
    @TableField("FUNCTION_ID")
    private String functionId;

    @Schema(description ="数据源主键")
    @TableField("SOURCE_ID")
    private String sourceId;

    @Schema(description ="数据来源表")
    @TableField("SOURCE_TABLE")
    private String sourceTable;

    @Schema(description ="备注")
    @TableField("REMARK")
    private String remark;




}
