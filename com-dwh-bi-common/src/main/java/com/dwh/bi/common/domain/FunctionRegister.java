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
@TableName("FUNCTION_REGISTER")
public class FunctionRegister extends BaseDomain<FunctionRegister> implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("FUNCTION_NAME")
    private String functionName;

    @TableField("FUNCTION_CODE")
    private String functionCode;

    @TableField("SYSTEM_ID")
    private String systemId;

    @TableField("REMARK")
    private String remark;



}
