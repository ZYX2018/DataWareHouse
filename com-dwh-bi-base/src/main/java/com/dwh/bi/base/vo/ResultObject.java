package com.dwh.bi.base.vo;

import cn.hutool.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultObject<T> {

    private Long responseTime;

    private int code;

    private String message;

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
