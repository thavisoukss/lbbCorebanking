package com.lbb.corebanking.domain.model.fundtransfer;

import lombok.Data;

import java.util.List;

@Data
public class BuyGoldTransferRes {

    private String code;
    private int status;
    private String responseType;
    private String message;
    private long journalNo;

    private Details details;

    private List<Object> warningInfoList;
}
