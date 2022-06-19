package com.dwh.bi.common.params;

import com.dwh.bi.base.params.CommonPageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author moon
 */
@Data
@NoArgsConstructor
@Schema(description = "任务执行参数")
public class DsDataTaskExecuteParam extends CommonPageParam {

    @Schema(description = "表名")
    private String tableName;


}
