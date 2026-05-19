package com.lbb.corebanking.domain.model.fundtransfer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class TransferResponse {
    @JsonProperty("code")
    private String code;

    @JsonProperty("status")
    private Integer status;

    @JsonProperty("responseType")
    private String responseType;

    @JsonProperty("message")
    private String message;

    @JsonProperty("journalNo")
    private Long journalNo;

    @JsonProperty("details")
    private TransferDetails details;

    @JsonProperty("warningInfoList")
    private List<Object> warningInfoList;
}
