package com.dwh.bi.common.params;

import com.dwh.bi.base.params.CommonPageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author moon
 */
@Data
@Schema(name = "系统分页查询参数",description = "系统分页查询参数")
public class SystemPageParam extends CommonPageParam {
    @Schema(description = "系统名称")
    private String name;
    @Schema(description = "系统ip")
    private String ip;

}
