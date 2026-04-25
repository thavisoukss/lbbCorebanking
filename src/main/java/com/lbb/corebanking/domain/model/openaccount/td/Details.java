package com.lbb.corebanking.domain.model.openaccount.td;

import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Data
public class Details {
    private String acctNo;
    private String certificateNo;
    private String acctType;
    private String contractType;
    private String ibanCode;
    private String globalIdType;
    private String globalId;
    private String clientNo;
    private String clientShort;
    private String acctDesc;
    private String branch;
    private String ccy;
    private String ownershipType;
    private String acctStatus;

    private OffsetDateTime origAcctOpenDate;
    private OffsetDateTime acctOpenDate;
    private OffsetDateTime openTranDate;
    private OffsetDateTime lastChangeDate;

    private String profitCentre;
    private String clientInd;
    private String docType;
    private String officerId;
    private String stmtPbk;
    private String intStmt;

    private int freeCheques;
    private String exceedRfLimit;
    private double toleranceAmt;

    private String ataAcct;
    private OffsetDateTime acctCloseDate;
    private String acctCloseReason;

    private String nbcCode;
    private String hoRepCode;
    private String actualOrLedgerBal;
    private String islamicInd;
    private String autoGenerateAcctNo;
    private String oldProductCode;

    private List<Object> jointAcctList;

    private Object intDetailRec;
    private Object acctStmtRec;
    private Object tdaRec;

    private ProdScDefRec prodScDefRec;

    private List<Object> prodScIndividualList;
    private List<Object> prodScMaintFeeList;
    private List<Object> depFeeApplyList;
    private List<Object> docDomainObjDefnList;

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

    private Header header;

    private Object securityHint;
    private Object digitalSignature;
    private String hasNextYn;
    private List<Object> messageInfoList;
    private Boolean hasError;
    private String publicKey;
    private Object lastSuccessfulValidation;
    private Object changeSummary;

}
