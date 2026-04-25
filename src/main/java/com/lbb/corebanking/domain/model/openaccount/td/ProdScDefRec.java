package com.lbb.corebanking.domain.model.openaccount.td;

import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Data
public class ProdScDefRec {

    private String prodNo;
    private String moduleId;
    private String subType;
    private String stopSc;
    private String thirdPartyAcctNo;

    private Object scException;
    private Object scGroupCode;
    private Object scPackType;

    private String fwEligible;
    private String fwStatus;
    private String taxFiler;

    private int version;
    private int bizVersion;

    private String createdBy;
    private OffsetDateTime createdDt;
    private OffsetDateTime journalDt;
    private int journalNo;

    private String modifiedBy;
    private OffsetDateTime modifiedDt;

    private List<Object> virtualAttributeList;
    private List<Object> dataExtensionList;

    private Object header;
    private Object securityHint;
    private Object digitalSignature;
    private String hasNextYn;
    private List<Object> messageInfoList;
    private Boolean hasError;
    private String publicKey;
    private Object lastSuccessfulValidation;
    private Object changeSummary;
}
