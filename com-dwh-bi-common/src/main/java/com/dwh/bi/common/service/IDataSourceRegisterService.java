package com.dwh.bi.common.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dwh.bi.base.vo.ResultObject;
import com.dwh.bi.common.domain.DataSourceRegister;
import com.dwh.bi.common.params.DataSourcePageParam;
import com.dwh.bi.common.vo.DataSourceRegisterVO;
import com.github.yulichang.base.MPJBaseService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhangyx-v
 * @since 2022-06-19
 */
public interface IDataSourceRegisterService extends MPJBaseService<DataSourceRegister> {
    /**
     *分页查询
     * @param pageParamParam pageParamParam
     * @return DataSourceRegisterVO
     */
    IPage<DataSourceRegisterVO> page(DataSourcePageParam pageParamParam);

    /**
     * getOneRegister
     * @param ip ip
     * @param port port
     * @param dbName dbName
     * @return DataSourceRegister
     */
    DataSourceRegister getOneRegister(String ip , String port ,String dbName);

    /**
     * 动态新增或更新数据源
     * @param registerVO registerVO
     * @return res
     */
    ResultObject saveOrUpdateDsDataSource(DataSourceRegisterVO registerVO);

    /**
     * remove
     * @param dataSourceId id
     * @return res
     */
    ResultObject removeDsDataSource(String dataSourceId);

}
