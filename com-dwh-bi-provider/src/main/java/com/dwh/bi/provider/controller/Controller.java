package com.dwh.bi.provider.controller;

import com.dwh.bi.base.vo.ResultObject;
import com.dwh.bi.provider.vo.DataSourceVO;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/data-source")
public class Controller {

    private static  final List<DataSourceVO> sourceList = new LinkedList<DataSourceVO>(){{
        add(new DataSourceVO("local","10.0.106,14","3306"));
        add(new DataSourceVO("test","10.0.106.38","3306"));
        add(new DataSourceVO("pro","10.0.106.99","3306"));
    }};

    @GetMapping("/list")
    public ResultObject<List<DataSourceVO>> queryDataSources(@RequestParam("sourceName") final String sourceName){
        return ResultObject.success(sourceList.stream().filter(source->source.getName().equals(sourceName)).collect(Collectors.toList()));
    }
    @PostMapping("/add")
    public ResultObject<List<DataSourceVO>> queryDataSources(@RequestBody DataSourceVO source){
        sourceList.add(source);
        return ResultObject.success(sourceList);
    }
    @GetMapping("/test")
    public ResultObject test(){
        return ResultObject.success("test sourceName");
    }
}
