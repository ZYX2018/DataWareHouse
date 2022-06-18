package com.dwh.bi.common.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dwh.bi.base.domain.BaseDomain;
import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhangyx-v
 * @since 2022-06-19
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("SYSTEM_REGISTER")
@Schema(name  = "SystemRegister对象", description = "系统注册")
public class SystemRegister extends BaseDomain<SystemRegister> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description ="系统名称")
    @TableField("SYSTEM_NAME")
    private String systemName;

    @Schema(description ="工作路径")
    @TableField("WORK_PATH")
    private String workPath;

    @Schema(description ="日志路径")
    @TableField("LOG_PATH")
    private String logPath;

    @Schema(description ="部署路径")
    @TableField("DEPLOY_PATH")
    private String deployPath;

    @Schema(description ="服务IP")
    @TableField("SYSTEM_IP")
    private String systemIp;

    @Schema(description ="运行端口")
    @TableField("SYSTEM_PORT")
    private String systemPort;

    @Schema(description ="备注")
    @TableField("REMARK")
    private String remark;



}
