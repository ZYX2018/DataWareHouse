package com.dwh.bi.common.vo;

import com.dwh.bi.base.vo.BaseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DataSourceVO
 * @author moon
 */
@Data
@NoArgsConstructor
@Schema(name = "数据源VO",description = "数据源VO")
public class DataSourceRegisterVO extends BaseVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description ="数据源名称")
    private String sourceName;

    @Schema(description ="数据源名称")
    private String sourceType;

    @Schema(description ="数据源IP")
    private String sourceIp;

    @Schema(description ="数据源端口")
    private String sourcePort;

    @Schema(description ="账户名称")
    private String userName;

    @Schema(description ="密码")
    private String userPassword;

    @Schema(description ="备注")
    private String remark;

}
