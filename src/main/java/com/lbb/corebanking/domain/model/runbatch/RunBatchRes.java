package com.lbb.corebanking.domain.model.runbatch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RunBatchRes {

    private String code;
    private Integer status;
    private String responseType;
    private String message;
    private Long journalNo;
    private Details details;
    private List<Object> warningInfoList;

}
