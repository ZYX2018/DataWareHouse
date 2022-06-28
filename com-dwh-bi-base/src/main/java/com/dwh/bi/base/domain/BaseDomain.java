package com.dwh.bi.base.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author moon
 */
@Getter
@Setter
@Accessors(chain = true)
@Schema(description = "基表")
public class BaseDomain<T> {
    @Schema(description = "主键")
    @TableId(value = "ID", type = IdType.ASSIGN_ID)
    private Long id;
    @Schema(description ="创建时间")
    @TableField("CREATE_TIME")
    private LocalDateTime createTime = LocalDateTime.now();

   @Schema(description ="创建人")
    @TableField("CREATE_USER")
    private String createUser;

   @Schema(description ="更新时间")
    @TableField("UPDATE_TIME")
    private LocalDateTime updateTime = LocalDateTime.now();

   @Schema(description ="更新人")
    @TableField("UPDATE_USER")
    private String updateUser;

}
