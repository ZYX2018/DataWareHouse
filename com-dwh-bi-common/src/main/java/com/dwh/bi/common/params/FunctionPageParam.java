package com.dwh.bi.common.params;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author moon
 */
@Data
@NoArgsConstructor
public class FunctionPageParam extends  CommonPage{

    private String name;

    private String code;

}
