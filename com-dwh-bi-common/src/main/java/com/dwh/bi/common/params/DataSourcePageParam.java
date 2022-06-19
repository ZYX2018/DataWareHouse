package com.dwh.bi.common.params;

import com.dwh.bi.base.params.CommonPageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author moon
 */
@Data
@NoArgsConstructor
@Schema(name = "数据源分页查询参数",description = "数据源分页查询参数")
public class DataSourcePageParam extends CommonPageParam {
    @Schema(description = "数据源ip")
    private String ip;
    @Schema(description = "数据源名称")
    private String  dataSourceName;

}
