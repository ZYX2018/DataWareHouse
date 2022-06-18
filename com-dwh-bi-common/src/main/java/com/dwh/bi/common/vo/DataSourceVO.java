package com.dwh.bi.common.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DataSourceVO
 * @author moon
 */
@Data
@NoArgsConstructor
@Schema(description = "数据源VO")
public class DataSourceVO {

    @Schema(description = "数据源名称")
    private String name;
    @Schema(description = "数据源IP")
    private String ip;
    @Schema(description = "数据源端口")
    private String port;

    public DataSourceVO(String name, String ip, String port) {
        this.name = name;
        this.ip = ip;
        this.port = port;
    }
}
