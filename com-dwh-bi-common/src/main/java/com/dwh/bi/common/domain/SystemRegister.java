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
public class SystemRegister extends BaseDomain<SystemRegister> implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("SYSTEM_NAME")
    private String systemName;

    @TableField("WORK_PATH")
    private String workPath;

    @TableField("LOG_PATH")
    private String logPath;

    @TableField("DEPLOY_PATH")
    private String deployPath;

    @TableField("SYSTEM_IP")
    private String systemIp;

    @TableField("SYSTEM_PORT")
    private String systemPort;

    @TableField("REMARK")
    private String remark;



}
