package com.lbb.corebanking.domain.model.openaccount;

import lombok.Data;

@Data
public class ProdScDefRec {
    private String prodNo;
    private String moduleId;
    private String subType;
    private String stopSc;
    private String thirdPartyAcctNo;
    private String scException;
    private String scGroupCode;
    private String scPackType;
    private String fwEligible;
    private String fwStatus;
    private String taxFiler;
    private int version;
    private int bizVersion;
    private String createdBy;
    private String createdDt;
    private String journalDt;
    private int journalNo;
    private String modifiedBy;
    private String modifiedDt;

}
