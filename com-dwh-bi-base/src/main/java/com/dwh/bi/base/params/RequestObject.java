package com.dwh.bi.base.params;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestObject <T>{

    private Long requestTime;

    private T params;

}
