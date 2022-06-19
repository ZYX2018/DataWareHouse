package com.dwh.bi.base.vo;

import cn.hutool.http.HttpStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 接口返回信息
 * @author moon
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "接口返回信息",description = "接口返回信息")
public class ResultObject<T> {

    @Schema(description = "请求时间")
    private Long responseTime;
    @Schema(description = "http status")
    private int code;
    @Schema(description = "错误信息")
    private String message;
    @Schema(description = "json 对象")
    private T data;

    public static ResultObject success(Object data){
        ResultObject res = new ResultObject();
        res.code = HttpStatus.HTTP_OK;
        res.data = data;
        return res;
    }

    public static ResultObject fail(String message , int code){
        ResultObject res = new ResultObject();
        res.code = code;
        res.message = message;
        return res;
    }
}
