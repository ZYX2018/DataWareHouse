package com.dwh.bi.common.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.dwh.bi.common.mapper.DsDataTaskExecuteMapper;
import com.dwh.bi.common.params.DsDataTaskExecuteParam;
import com.dwh.bi.common.service.IDsDataTaskExecuteService;
import com.dwh.bi.common.sql.builder.DsDataTaskExecuteSqlBuilder;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Service;



/**
 * @author moon
 */
@Service
public class DsDataTaskExecuteServiceImpl extends ServiceImpl<DsDataTaskExecuteMapper, JSONObject> implements IDsDataTaskExecuteService {



}
