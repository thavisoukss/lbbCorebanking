package com.lbb.corebanking.domain.model.statmentdetialout;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SwfAcctLineStructRec {


    private String acctIdentification;
    private String clearingCodeSystem;
    private String accountNo;

    private Integer version;
    private Integer bizVersion;
    private String createdBy;

    private String createdDt;

    private String journalDt;

    private Long journalNo;
    private String modifiedBy;

    private String modifiedDt;

    private List<Object> virtualAttributeList;
    private List<Object> dataExtensionList;
    private Header header;
    private Object securityHint;
    private Object digitalSignature;
    private String hasNextYn;
    private List<Object> messageInfoList;
    private Boolean hasError;
    private String publicKey;
    private String lastSuccessfulValidation;
    private String changeSummary;

}
