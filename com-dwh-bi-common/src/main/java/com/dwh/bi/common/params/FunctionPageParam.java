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
@Schema(name = "功能分页查询参数",description = "功能分页查询参数")
public class FunctionPageParam extends CommonPageParam {
    @Schema(description = "功能名称")
    private String name;
    @Schema(description = "功能编码")
    private String code;

}
