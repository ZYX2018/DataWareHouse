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
@Schema(name =  "FunctionRegister对象", description = "功能注册")
public class FunctionRegister extends BaseDomain<FunctionRegister> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description ="功能名称")
    @TableField("FUNCTION_NAME")
    private String functionName;

    @Schema(description ="功能编码")
    @TableField("FUNCTION_CODE")
    private String functionCode;

    @Schema(description ="系统主键")
    @TableField("SYSTEM_ID")
    private String systemId;

    @Schema(description ="备注")
    @TableField("REMARK")
    private String remark;



}
