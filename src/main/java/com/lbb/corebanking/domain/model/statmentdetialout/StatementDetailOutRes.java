package com.lbb.corebanking.domain.model.statmentdetialout;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatementDetailOutRes {
    private String code;
    private Integer status;
    private String responseType;
    private String message;
    private Long journalNo;
    private StatementDetailOutData details;
    private List<Object> warningInfoList;
}
