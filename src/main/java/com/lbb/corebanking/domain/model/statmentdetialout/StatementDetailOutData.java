package com.lbb.corebanking.domain.model.statmentdetialout;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatementDetailOutData {


    private String refNo;
    private String tranStatus;
    private String tranSource;
    private String tranType;

    private String tranDate;

    private String tranCountry;
    private BigDecimal totalDrAmount;
    private BigDecimal totalCrAmount;
    private String instructedCcy;
    private BigDecimal instructedAmount;

    private String instructedDate;

    private String fixedSide;

    // Debit side
    private String drValueDate;

    private String drClientNo;
    private String drGlType;
    private String drAcctNo;
    private String drGlCode;
    private String drBranch;
    private String drProfitCentre;
    private Long drSeqNo;
    private String drCcy;
    private BigDecimal drAmount;
    private String drSettleMtd;
    private BigDecimal drBaseEquiv;

    // Credit side

    private String crValueDate;

    private String crCcy;
    private BigDecimal crAmount;
    private String crClientNo;
    private String crGlType;
    private String crAcctNo;
    private String crGlCode;
    private String crBranch;
    private String crProfitCentre;
    private Long crSeqNo;
    private String crSettleMtd;
    private BigDecimal crBaseEquiv;

    // Detail amounts
    private BigDecimal dtlDebitAmount;
    private BigDecimal drChargeAmount;
    private BigDecimal drExchRate;
    private String drExchQuote;
    private BigDecimal dtlCreditAmount;
    private BigDecimal crChargeAmount;
    private BigDecimal crExchRate;
    private String crExchQuote;

    private String rateType;
    private String kondorRefNo;
    private BigDecimal spotRate;
    private String spotQuote;
    private String acctExec;
    private String bookBranch;
    private String incRefNo;
    private String channel;
    private String channelSource;
    private String channelRefNo;
    private String narrative;
    private String rejectReason;
    private String errorCodeMsg;
    private String variableSymbol;
    private String constantSymbol;
    private String specificSymbol;
    private String tranTime;
    private String tranClass;
    private BigDecimal origSpotRate;
    private String srcProgramId;
    private String firstUserId;
    private String lastUserId;
    private String verifiedBy;
    private String drSwfSettleKey;
    private String crSwfSettleKey;

    private PaymentOrdDetailRec paymentOrdDetailRec;
    private List<PaymentsCharge> paymentsChargesList;

    private Object crCommonSettleNostroMt202Rec;
    private Object crCommonSettleNostroMt200Rec;
    private Object drCommonSettleNostroMt210Rec;
    private String rbRestrSeqNo;

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
