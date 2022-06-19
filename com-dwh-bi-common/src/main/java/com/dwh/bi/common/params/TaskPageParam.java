package com.dwh.bi.common.params;

import com.dwh.bi.base.params.CommonPageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author moon
 */
@Data
@Schema(name = "任务分页查询",description = "任务分页查询")
public class TaskPageParam extends CommonPageParam {

    @Schema(description="数据源名称")
    private String sourceName;

    @Schema(description="数据来源表")
    private String sourceTable;

    @Schema(description="服务名")
    private String systemName;

    @Schema(description="功能名")
    private String functionName;

    @Schema(description="任务名称")
    private String taskName;
}
