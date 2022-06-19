package com.dwh.bi.common.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dwh.bi.common.domain.FunctionRegister;
import com.dwh.bi.common.mapper.FunctionRegisterMapper;
import com.dwh.bi.common.params.FunctionPageParam;
import com.dwh.bi.common.service.IFunctionRegisterService;
import com.dwh.bi.common.vo.FunctionRegisterVO;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangyx-v
 * @since 2022-06-19
 */
@Service
public class FunctionRegisterServiceImpl extends MPJBaseServiceImpl<FunctionRegisterMapper, FunctionRegister> implements IFunctionRegisterService {

    private final FunctionRegisterMapper functionRegisterMapper;

    public FunctionRegisterServiceImpl(FunctionRegisterMapper functionRegisterMapper) {
        this.functionRegisterMapper = functionRegisterMapper;
    }

    @Override
    public IPage<FunctionRegisterVO> page(FunctionPageParam pageParamParam) {
        MPJLambdaWrapper<FunctionRegisterVO> wrapper =   new MPJLambdaWrapper<FunctionRegisterVO>()
                .selectAll(FunctionRegister.class);
        if (StringUtils.isNotEmpty(pageParamParam.getName())&&StringUtils.isNotEmpty(pageParamParam.getCode())){
            wrapper = wrapper.like(FunctionRegister::getFunctionName,pageParamParam.getName()).or().like(FunctionRegister::getFunctionCode, pageParamParam.getCode());
        }else if(StringUtils.isNotEmpty(pageParamParam.getName())){
            wrapper = wrapper.like(FunctionRegister::getFunctionName,pageParamParam.getName());
        }else if (StringUtils.isNotEmpty(pageParamParam.getCode())){
            wrapper = wrapper.like(FunctionRegister::getFunctionCode, pageParamParam.getCode());
        }
        return functionRegisterMapper.selectJoinPage(new Page<>(pageParamParam.getPage(),pageParamParam.getPageSize()),FunctionRegisterVO.class,wrapper);
    }
}
