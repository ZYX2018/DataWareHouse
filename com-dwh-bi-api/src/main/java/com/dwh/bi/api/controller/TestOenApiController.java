package com.dwh.bi.api.controller;

import com.dwh.bi.base.vo.ResultObject;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author moon
 */
@RestController
@RequestMapping("/openApi/v1/test")
@Tag(name = "测试 open api",description = "测试open api")
public class TestOenApiController {

    @Operation(description = "测试",summary = "测试")
    @GetMapping("/flag")
    public ResultObject<Boolean> test(@RequestParam("flag")String flag){
        return ResultObject.success(Boolean.getBoolean(flag));
    }
}
