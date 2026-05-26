package com.lbb.corebanking.domain.model.buygold;

import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Data
public class Details {
    private String refNo;
    private String tranStatus;
    private String tranSource;
    private String tranType;
    private OffsetDateTime tranDate;
    private String tranCountry;

    private BigDecimal totalDrAmount;
    private BigDecimal totalCrAmount;

    private String instructedCcy;
    private BigDecimal instructedAmount;
    private OffsetDateTime instructedDate;

    private String fixedSide;

    private OffsetDateTime drValueDate;
    private String drClientNo;
    private String drGlType;
    private String drAcctNo;
    private String drGlCode;
    private String drBranch;
    private String drProfitCentre;
    private Integer drSeqNo;
    private String drCcy;
    private BigDecimal drAmount;
    private String drSettleMtd;
    private BigDecimal drBaseEquiv;

    private OffsetDateTime crValueDate;
    private String crCcy;
    private BigDecimal crAmount;
    private String crClientNo;
    private String crGlType;
    private String crAcctNo;
    private String crGlCode;
    private String crBranch;
    private String crProfitCentre;
    private Integer crSeqNo;
    private String crSettleMtd;
    private BigDecimal crBaseEquiv;

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

    private OffsetDateTime tranTime;
    private String tranClass;

    private BigDecimal origSpotRate;
    private String srcProgramId;

    private String firstUserId;
    private String lastUserId;
    private String verifiedBy;

    private String drSwfSettleKey;
    private String crSwfSettleKey;

    private BuyGoldPaymentOrdDetailRec paymentOrdDetailRec;

    private List<Object> paymentsChargesList;

    private Object crCommonSettleNostroMt202Rec;
    private Object crCommonSettleNostroMt200Rec;
    private Object drCommonSettleNostroMt210Rec;

    private Integer rbRestrSeqNo;

    private int version;
    private int bizVersion;

    private String createdBy;
    private OffsetDateTime createdDt;
    private OffsetDateTime journalDt;
    private long journalNo;

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
