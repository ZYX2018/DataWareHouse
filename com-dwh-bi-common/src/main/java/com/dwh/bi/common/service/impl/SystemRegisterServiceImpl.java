package com.dwh.bi.common.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dwh.bi.common.domain.SystemRegister;
import com.dwh.bi.common.mapper.SystemRegisterMapper;
import com.dwh.bi.common.params.SystemPageParam;
import com.dwh.bi.common.service.ISystemRegisterService;
import com.dwh.bi.common.vo.SystemRegisterVO;
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
public class SystemRegisterServiceImpl extends MPJBaseServiceImpl<SystemRegisterMapper, SystemRegister> implements ISystemRegisterService {

    private final  SystemRegisterMapper systemRegisterMapper;

    public SystemRegisterServiceImpl(SystemRegisterMapper systemRegisterMapper) {
        this.systemRegisterMapper = systemRegisterMapper;
    }

    @Override
    public IPage<SystemRegisterVO> page(SystemPageParam pageParamParam) {
        MPJLambdaWrapper<SystemRegisterVO> wrapper =  new MPJLambdaWrapper<SystemRegisterVO>().selectAll(SystemRegister.class);
        if (StringUtils.isNotEmpty(pageParamParam.getIp())){
            wrapper = wrapper.like(SystemRegister::getSystemIp,pageParamParam.getIp());
        }
        if (StringUtils.isNotEmpty(pageParamParam.getName())){
            wrapper = wrapper.like(SystemRegister::getSystemName,pageParamParam.getName());
        }
        return systemRegisterMapper.selectJoinPage(new Page<>(pageParamParam.getPage(),pageParamParam.getPageSize()),SystemRegisterVO.class, wrapper);
    }
}
