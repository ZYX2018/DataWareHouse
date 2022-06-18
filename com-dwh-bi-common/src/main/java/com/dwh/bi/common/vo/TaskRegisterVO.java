package com.dwh.bi.common.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author moon
 */
@Data
@NoArgsConstructor
@Schema(name = "TaskRegisterVO" ,description = "注册任务VO")
public class TaskRegisterVO {


    @Schema(description="任务名称")
    @TableField("TASK_NAME")
    private String taskName;

    @Schema(description="任务编码")
    @TableField("TASK_CODE")
    private String taskCode;

    @Schema(description="服务名")
    @TableField("SYSTEM_ID")
    private String systemName;

    @Schema(description="功能名")
    @TableField("FUNCTION_ID")
    private String functionName;

    @Schema(description="数据源名称")
    @TableField("SOURCE_ID")
    private String sourceName;

    @Schema(description="数据来源表")
    @TableField("SOURCE_TABLE")
    private String sourceTable;

    @Schema(description="备注")
    @TableField("REMARK")
    private String remark;
}
