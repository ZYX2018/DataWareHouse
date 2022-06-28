package com.dwh.bi.common.params;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author zhangyx-v
 */
@Data
@Schema(name = "TablesParam",description = "表查询参数")
public class TablesParam {

    @Schema(name = "sourceId",description = "数据源主键")
    @NotBlank
    private String sourceId;
}
