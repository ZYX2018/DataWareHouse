package com.dwh.bi.api.controller;

import cn.hutool.http.HttpStatus;
import com.alibaba.fastjson2.JSONObject;
import com.dwh.bi.base.vo.ResultObject;
import com.dwh.bi.common.vo.DataSourceRegisterVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author moon
 */
@RestController
@RequestMapping("/openApi/v1/test")
@Tag(name = "测试 open api",description = "测试open api")
public class TestOenApiController {

    @Operation(description = "测试",summary = "测试")
    @GetMapping("/flag")
    public ResultObject<String> test(@RequestBody DataSourceRegisterVO  source){
        String url="";
        Connection con;
        try {
            url ="jdbc:mysql://"+source.getSourceIp()+":"+source.getSourcePort()+"/"+source.getSourceName();
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection(url, source.getUserName(), source.getUserPassword());
        } catch (Exception e) {
            return ResultObject.fail("链接失败"+e.getMessage(), HttpStatus.HTTP_BAD_REQUEST);
        }
        return ResultObject.success("链接成功 ："+ url);
    }
}
