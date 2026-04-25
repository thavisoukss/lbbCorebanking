package com.lbb.corebanking.domain.model.openaccount.td;

import lombok.Data;

import java.util.List;

@Data
public class OpenAccRes {

    private String code;
    private int status;
    private String responseType;
    private String message;
    private int journalNo;
    private Details details;
    private List<Object> warningInfoList;

}
