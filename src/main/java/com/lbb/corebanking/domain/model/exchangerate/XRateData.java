package com.lbb.corebanking.domain.model.exchangerate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class XRateData {

    private String xrateRefNo;
    private String xrateType;
    private String baseCcy;
    private String ccy;
    private String branch;

    private String effectFromDt;
    private String effectToDt;

    private String quoteType;

    private double midRate;
    private double buyRate;
    private double sellRate;

    private Boolean batchYn;
    private Boolean historyYn;

    private String historyDt;

    private int version;
    private int bizVersion;

    private String createdBy;
    private String createdDt;

    private String journalDt;
    private long journalNo;

    private String modifiedBy;
    private String modifiedDt;

    private List<Object> virtualAttributeList;
    private List<Object> dataExtensionList;

    private Object header;
    private Object securityHint;
    private Object digitalSignature;

    private Boolean hasNextYn;

    private List<Object> messageInfoList;

    private Boolean hasError;

    private String publicKey;

    private String lastSuccessfulValidation;
    private Object changeSummary;
}
