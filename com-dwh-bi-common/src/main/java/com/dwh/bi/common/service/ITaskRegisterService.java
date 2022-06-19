package com.dwh.bi.common.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dwh.bi.common.domain.TaskRegister;
import com.dwh.bi.common.params.TaskPageParam;
import com.dwh.bi.common.vo.TaskRegisterVO;
import com.github.yulichang.base.MPJBaseService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhangyx-v
 * @since 2022-06-19
 */
public interface ITaskRegisterService extends MPJBaseService<TaskRegister> {

    /**
     * 分页查询任务列表
     * @param pageParam 分页参数
     * @return  任务列表
     */
    IPage<TaskRegisterVO> selectPageTaskRegister(TaskPageParam pageParam);

}
