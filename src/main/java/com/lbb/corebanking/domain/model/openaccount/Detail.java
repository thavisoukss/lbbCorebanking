package com.lbb.corebanking.domain.model.openaccount;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Detail {
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

    private String origAcctOpenDate;
    private String acctOpenDate;
    private String openTranDate;
    private String lastChangeDate;
    private String profitCentre;
    private String clientInd;
    private String docType;
    private String officerId;
    private String stmtPbk;


    private String intStmt;
    private int freeCheques;
    private String exceedRfLimit;
    private BigDecimal toleranceAmt;
    private String ataAcct;
    private String acctCloseDate;
    private String acctCloseReason;
    private String nbcCode;
    private String hoRepCode;


    private String actualOrLedgerBal;
    private String islamicInd;
    private String autoGenerateAcctNo;
    private String oldProductCode;
    List<JointAcctList> jointAcctList;
    private String intDetailRec;
    private String acctStmtRec;
    private String tdaRec;
    ProdScDefRec prodScDefRec;
    List<ProdScIndividualList>prodScIndividualList;
    List<ProdScMaintFeeList>prodScMaintFeeList;
    List<DepFeeApplyList> depFeeApplyList;
    List<DocDomainObjDefnList> docDomainObjDefnList;
    private int version;
    private int bizVersion;
    private String createdBy;
    private String createdDt;
    private String journalDt;
    private int journalNo;
    private String modifiedBy;
    private String modifiedDt;
    List<VirtualAttributeList> virtualAttributeList;
    List<DataExtensionList>dataExtensionList;
    Header header;
    private String securityHint;
    private String digitalSignature;
    private String hasNextYn;
    List<MessageInfoList>messageInfoList;
    private String hasError;
    private String publicKey;
    private String lastSuccessfulValidation;
    private String changeSummary;





}
