package com.dwh.bi.common.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dwh.bi.common.domain.DataSourceRegister;
import com.dwh.bi.common.domain.FunctionRegister;
import com.dwh.bi.common.domain.SystemRegister;
import com.dwh.bi.common.domain.TaskRegister;
import com.dwh.bi.common.mapper.TaskRegisterMapper;
import com.dwh.bi.common.service.ITaskRegisterService;
import com.dwh.bi.common.params.TaskPageParam;
import com.dwh.bi.common.vo.TaskRegisterVO;
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
public class TaskRegisterServiceImpl extends MPJBaseServiceImpl<TaskRegisterMapper, TaskRegister> implements ITaskRegisterService {

    private final TaskRegisterMapper taskRegisterMapper;

    public TaskRegisterServiceImpl(TaskRegisterMapper taskRegisterMapper) {
        this.taskRegisterMapper = taskRegisterMapper;
    }

    @Override
    public IPage<TaskRegisterVO> selectPageTaskRegister(TaskPageParam pageParam) {
        MPJLambdaWrapper<TaskRegisterVO> wrapper = new MPJLambdaWrapper<TaskRegisterVO>().selectAll(TaskRegister.class).selectAs(SystemRegister::getSystemName,TaskRegisterVO::getSystemName).selectAs(FunctionRegister::getFunctionName,TaskRegisterVO::getFunctionName)
                .selectAs(DataSourceRegister::getSourceName,TaskRegisterVO::getSourceName).selectAs(DataSourceRegister::getId,TaskRegisterVO::getSourceId).leftJoin(SystemRegister.class,SystemRegister::getId,TaskRegister::getSystemId)
                .leftJoin(FunctionRegister.class,FunctionRegister::getId,TaskRegister::getFunctionId).leftJoin(DataSourceRegister.class,DataSourceRegister::getId,TaskRegister::getSourceId);
        if (StringUtils.isNotEmpty(pageParam.getSourceTable())) {
            wrapper = wrapper.like(TaskRegister::getSourceTable,pageParam.getSourceTable());
        }
        if (StringUtils.isNotEmpty(pageParam.getSystemName())){
            wrapper = wrapper.like(SystemRegister::getSystemName,pageParam.getSystemName());
        }
        if (StringUtils.isNotEmpty(pageParam.getSourceName())){
            wrapper = wrapper.like(DataSourceRegister::getSourceName,pageParam.getSourceName());
        }
        if (StringUtils.isNotEmpty(pageParam.getFunctionName())){
            wrapper = wrapper.like(FunctionRegister::getFunctionName,pageParam.getFunctionName());
        }
        IPage<TaskRegisterVO> voiPage =  taskRegisterMapper.selectJoinPage(new Page<>(pageParam.getPage(),pageParam.getPageSize()),TaskRegisterVO.class, wrapper);
        return voiPage;
    }
}
