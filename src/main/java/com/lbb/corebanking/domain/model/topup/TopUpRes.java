package com.lbb.corebanking.domain.model.topup;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TopUpRes {
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
    private TopUpDetails details;

    @JsonProperty("warningInfoList")
    private List<Object> warningInfoList;

}
