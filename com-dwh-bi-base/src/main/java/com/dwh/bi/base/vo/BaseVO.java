package com.dwh.bi.base.vo;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

/**
 * 基础VO
 * @author moon
 */
@Schema(description = "基础vo")
public class BaseVO {
    @Schema(description ="创建时间")
    private LocalDateTime createTime = LocalDateTime.now();

    @Schema(description ="创建人")
    private String createUser;

    @Schema(description ="更新时间")
    private LocalDateTime updateTime = LocalDateTime.now();

    @Schema(description ="更新人")
    private String updateUser;
}
