package com.dwh.bi.common.builder;

import com.dwh.bi.base.constants.DsDataSourceConstants;
import com.dwh.bi.common.domain.DataSourceRegister;
import com.dwh.bi.common.dto.DataSourceDTO;

/**
 * 构建者
 * @author zhangyx-v
 */
public class DataSourceDTOBuiler {


    private DataSourceDTO  dataSourceDTO = new DataSourceDTO();

    public static DataSourceDTOBuiler builder (){
        return new DataSourceDTOBuiler();
    }

    public DataSourceDTO build (){
        return dataSourceDTO;
    }

    public DataSourceDTO build(DataSourceRegister register){
       return this.url(register.getSourceIp(),register.getSourcePort(),register.getSourceName())
                    .userName(register.getUserName())
                    .password(register.getUserPassword())
                    .poolName(Long.toString(register.getId()))
                    .driverClassName(DsDataSourceConstants.MYSQL_DRIVER_CLASS_NAME).build();
    }

    public DataSourceDTOBuiler url (String ip , String port , String sourceName){
        String url ="jdbc:mysql://"+ip+":"+port+"/"+sourceName+"?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&serverTimezone=GMT%2B8";
        dataSourceDTO.setUrl(url);
        return  this;
    }

    public DataSourceDTOBuiler userName (String userName){
        dataSourceDTO.setUsername(userName);
        return this;
    }

    public DataSourceDTOBuiler password (String password){
        dataSourceDTO.setPassword(password);
        return this;
    }

    public DataSourceDTOBuiler poolName(String poolName){
        dataSourceDTO.setPoolName(poolName);
        return this;
    }

    public DataSourceDTOBuiler driverClassName (String driverClassName){
        dataSourceDTO.setDriverClassName(driverClassName);
        return  this;
    }
}
