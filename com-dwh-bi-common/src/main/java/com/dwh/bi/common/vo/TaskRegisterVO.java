package com.dwh.bi.common.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.dwh.bi.base.vo.BaseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author moon
 */
@Data
@NoArgsConstructor
@Schema(name = "注册任务VO" ,description = "注册任务VO")
public class TaskRegisterVO extends BaseVO {


    @Schema(description="任务名称")
    private String taskName;

    @Schema(description="任务编码")
    private String taskCode;

    @Schema(description="系统主键")
    private String systemId;

    @Schema(description="系统名称")
    private String systemName;

    @Schema(description="功能主键")
    private String functionId;

    @Schema(description="功能名")
    private String functionName;

    @Schema(description="数据源主键")
    private String sourceId;

    @Schema(description="数据源名称")
    private String sourceName;

    @Schema(description="数据来源表")
    private String sourceTable;

    @Schema(description="备注")
    private String remark;
}
