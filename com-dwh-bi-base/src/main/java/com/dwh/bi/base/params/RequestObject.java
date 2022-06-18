package com.dwh.bi.base.params;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "请求参数")
public class RequestObject <T>{

    @Schema(description = "请求时间")
    private Long requestTime;
    @Schema(description = "请求参数对象")
    private T params;

}
