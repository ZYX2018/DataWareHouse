package com.dwh.bi.common.params;

import com.dwh.bi.base.params.CommonPageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

/**
 * @author moon
 */
@Data
@NoArgsConstructor
@Schema(description = "任务执行参数")
public class DsDataRetrieveTaskExecuteParam extends CommonPageParam {

    @Schema(description = "任务主键")
    @NotBlank
    private String taskId;

    @Schema(description = "列名")
    private String[] columns ;

    @Schema(description = "筛选条件")
    private Optional<String> where = Optional.empty();

}
