package com.lbb.corebanking.domain.model.exchangerate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ApiResponse {

    private String code;
    private int status;
    private String responseType;
    private String message;
    private long journalNo;
    private Details details;
    private Object warningInfoList;
}
