package com.dwh.bi.common.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dwh.bi.base.domain.BaseDomain;
import java.io.Serializable;
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
public class DataSourceRegister extends BaseDomain<DataSourceRegister> implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("SOURCE_NAME")
    private String sourceName;

    @TableField("SOURCE_TYPE")
    private String sourceType;

    @TableField("SOURCE_IP")
    private String sourceIp;

    @TableField("SOURCE_PORT")
    private String sourcePort;

    @TableField("USER_NAME")
    private String userName;

    @TableField("USER_PASSWORD")
    private String userPassword;

    @TableField("INFORMATION_ID")
    private Long informationId;

    @TableField("REMARK")
    private String remark;



}
