package com.lbb.corebanking.domain.model.statementdeailin;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TranHistDetail {


    private Long seqNo;

    private String tranDate;

    private String acctNo;
    private String certificateNo;

    private String effectDate;

    private String tranType;
    private String crDrMaintInd;
    private BigDecimal tranCcyAmt;
    private String ccy;
    private BigDecimal tranAmt;
    private String reference;
    private String tranDesc;
    private String sourceRefType;
    private String sourceRefNo;
    private String crStatCode;
    private String drStatCode;
    private String sourceType;
    private String sourceModule;
    private Integer floatDays;
    private String referenceBank;
    private String referenceBranch;

    private String postDate;

    private String branch;
    private String purposeCode;

    private String entryDate;

    private String profitCentre;
    private String specCode;
    private String tranRefNo;
    private String taxable;
    private String taxDueToInt;
    private String servCharge;
    private String reversalInd;
    private String tfrAcctNo;
    private Long tfrSeqNo;
    private String stmtDetail1;
    private String rateType;
    private String channel;
    private String channelSource;
    private String channelRefNo;
    private String channelDetailInfo;
    private String terminalId;
    private String officerId;
    private BigDecimal previousBalAmt;
    private BigDecimal actualBalAmt;


    private String timeStamp;

    private Long journalSeqNo;
    private Long mvmtSeqNo;
    private String msgClient;
    private String othBankCode;
    private String othAcctNo;
    private String othAcctDesc;
    private String othReference;
    private String othSpecCode;

    private String othValueDate;

    private String referenceType;
    private String reversalTranType;

    private String reversalDate;

    private String pbkUpdFlag;

    private String stmtDate;

    private String traceId;
    private String overrideOfficer;
    private Long brSeqNo;
    private String cdCashFlowFlag;

    private String valueDate;

    private String btOfficerId;
    private String btOverrideId;
    private String receiptNo;
    private Long primarySeqNo;
    private String specificSymbol;
    private String othAcctDesc2;
    private String clientCrossRef;
    private String ttrn;
    private BigDecimal othAmt;
    private BigDecimal wdlPenaltyAmt;
    private BigDecimal intAmtWdrawn;
    private String wdlNoticeInd;
    private String clientName;
    private String idType;
    private String clientId;
    private String address;
    private String resident;
    private String clientType;
    private String categoryType;
    private String country;
    private String domesticForeign;
    private String placeOfIssuance;
    private String variableSymbol;
    private String penaltyApplyWay;
    private BigDecimal availedWdlAmt;
    private String printed;
    private String consolidateItem;
    private Long consSeqNo;
    private Integer sortPriority;
    private String permissionNo;

    private String dpTranDate;

    private Long dpSeqNo;
    private String ccyConv;

    private String origTranDate;

    private Long reversalSeqNo;
    private Long wdlSeqNo;
    private Long grpTranSeqNo;
    private String instCode;
    private String billReference;
    private String sdbInternalKey;
    private String sdbTranInd;
    private String voucherNo;
    private String acctCcy;

    private String startDt;

    private String endDt;

    private Long revTranSeqNo;
    private Long revContraTranSeqNo;
    private Object tranHistFcyRec;
    private Object cPartyRec;
    private Object tranHistIbftRec;
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
