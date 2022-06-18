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
@TableName("DATA_SOURCE_REGISTER")
@Schema(name  = "DataSourceRegister对象",  description = "数据源表")
public class DataSourceRegister extends BaseDomain<DataSourceRegister> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description ="数据源名称")
    @TableField("SOURCE_NAME")
    private String sourceName;

    @Schema(description ="数据源名称")
    @TableField("SOURCE_TYPE")
    private String sourceType;

    @Schema(description ="数据源IP")
    @TableField("SOURCE_IP")
    private String sourceIp;

    @Schema(description ="数据源端口")
    @TableField("SOURCE_PORT")
    private String sourcePort;

    @Schema(description ="账户名称")
    @TableField("USER_NAME")
    private String userName;

    @Schema(description ="密码")
    @TableField("USER_PASSWORD")
    private String userPassword;

    @Schema(description ="备注")
    @TableField("REMARK")
    private String remark;



}
