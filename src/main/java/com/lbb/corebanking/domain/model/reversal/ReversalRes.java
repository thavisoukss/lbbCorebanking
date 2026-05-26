package com.lbb.corebanking.domain.model.reversal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * CBS API Response wrapper
 * Main response object for all CBS API calls
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReversalRes {

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
    private ReversalTranDetails details;

    @JsonProperty("warningInfoList")
    private List<Object> warningInfoList;
}
