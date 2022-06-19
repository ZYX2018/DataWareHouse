package com.dwh.bi.common.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author moon
 */
@Data
@NoArgsConstructor
@Schema(name = "系统注册VO",description ="系统注册VO")
public class SystemRegisterVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(description ="系统名称")
    private String systemName;

    @Schema(description ="工作路径")
    private String workPath;

    @Schema(description ="日志路径")
    private String logPath;

    @Schema(description ="部署路径")
    private String deployPath;

    @Schema(description ="服务IP")
    private String systemIp;

    @Schema(description ="运行端口")
    private String systemPort;

    @Schema(description ="备注")
    private String remark;

}
