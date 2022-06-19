package com.dwh.bi.common.vo;

import com.dwh.bi.base.vo.BaseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 功能注册VO
 * @author moon
 */
@Data
@NoArgsConstructor
@Schema(name = "功能注册VO",description = "功能注册VO")
public class FunctionRegisterVO extends BaseVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(description ="功能名称")
    private String functionName;

    @Schema(description ="功能编码")
    private String functionCode;

    @Schema(description ="系统主键")
    private String systemId;

    @Schema(description ="备注")
    private String remark;
}
