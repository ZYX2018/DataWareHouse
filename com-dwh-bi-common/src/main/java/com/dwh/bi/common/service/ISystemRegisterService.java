package com.dwh.bi.common.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dwh.bi.common.domain.SystemRegister;
import com.dwh.bi.common.params.SystemPageParam;
import com.dwh.bi.common.vo.SystemRegisterVO;
import com.github.yulichang.base.MPJBaseService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhangyx-v
 * @since 2022-06-19
 */
public interface ISystemRegisterService extends MPJBaseService<SystemRegister> {
    /**
     *分页查询
     * @param pageParamParam pageParamParam
     * @return DataSourceRegisterVO
     */
    IPage<SystemRegisterVO> page(SystemPageParam pageParamParam);
}
