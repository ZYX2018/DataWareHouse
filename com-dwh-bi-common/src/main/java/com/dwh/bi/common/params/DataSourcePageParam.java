package com.dwh.bi.common.params;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author moon
 */
@Data
@NoArgsConstructor
public class DataSourcePageParam extends CommonPage{

    private String ip;

    private String  dataSourceName;

}
