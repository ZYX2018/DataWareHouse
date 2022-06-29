package com.dwh.bi.common.params;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Map;

/**
 * @author zhangyx-v
 */
@Data
@NoArgsConstructor
@Schema(description = "任务执行参数")
public class DsDataUpdateTaskExecuteParam {
    @Schema(description = "任务主键")
    @NotBlank
    private String taskId;
    @Schema(description = "更新列")
    @NotEmpty
    private Map<String,String> updateColumns ;
    @Schema(description = "数据主键 name:value")
    @NotBlank
    private String  where ;

}
