package com.dwh.bi.base.params;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 分页查询基础参数
 * @author moon
 */
@Data
@Schema(description = "分页查询基础参数")
public class CommonPageParam {
    @Schema(description = "页码")
    private int page;
    @Schema(description = "页尺寸")
    private int pageSize;
}
