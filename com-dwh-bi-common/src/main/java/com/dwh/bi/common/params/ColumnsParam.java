package com.dwh.bi.common.params;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author zhangyx-v
 */
@Data
@Schema(name = "列查询参数",description = "列查询参数")
public class ColumnsParam {
    @Schema(name = "sourceId",description = "数据源主键")
    @NotBlank
    private String sourceId;
    @Schema(name = "tableName",description = "表名")
    @NotBlank
    private String tableName;

}
