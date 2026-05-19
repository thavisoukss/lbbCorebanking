package com.lbb.corebanking.domain.model.topup;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TopUpDetails {

    @JsonProperty("refNo")
    private String refNo;

    @JsonProperty("tranStatus")
    private String tranStatus;

    @JsonProperty("tranSource")
    private String tranSource;

    @JsonProperty("tranType")
    private String tranType;

    @JsonProperty("tranDate")
    private String tranDate;

    @JsonProperty("tranCountry")
    private String tranCountry;

    @JsonProperty("totalDrAmount")
    private BigDecimal totalDrAmount;

    @JsonProperty("totalCrAmount")
    private BigDecimal totalCrAmount;

    @JsonProperty("instructedCcy")
    private String instructedCcy;

    @JsonProperty("instructedAmount")
    private BigDecimal instructedAmount;

    @JsonProperty("instructedDate")
    private String instructedDate;

    @JsonProperty("fixedSide")
    private String fixedSide;

    // ---------- Debit side ----------

    @JsonProperty("drValueDate")
    private String drValueDate;

    @JsonProperty("drClientNo")
    private String drClientNo;

    @JsonProperty("drGlType")
    private String drGlType;

    @JsonProperty("drAcctNo")
    private String drAcctNo;

    @JsonProperty("drGlCode")
    private String drGlCode;

    @JsonProperty("drBranch")
    private String drBranch;

    @JsonProperty("drProfitCentre")
    private String drProfitCentre;

    @JsonProperty("drSeqNo")
    private Integer drSeqNo;

    @JsonProperty("drCcy")
    private String drCcy;

    @JsonProperty("drAmount")
    private BigDecimal drAmount;

    @JsonProperty("drSettleMtd")
    private String drSettleMtd;

    @JsonProperty("drBaseEquiv")
    private BigDecimal drBaseEquiv;

    // ---------- Credit side ----------

    @JsonProperty("crValueDate")
    private String crValueDate;

    @JsonProperty("crCcy")
    private String crCcy;

    @JsonProperty("crAmount")
    private BigDecimal crAmount;

    @JsonProperty("crClientNo")
    private String crClientNo;

    @JsonProperty("crGlType")
    private String crGlType;

    @JsonProperty("crAcctNo")
    private String crAcctNo;

    @JsonProperty("crGlCode")
    private String crGlCode;

    @JsonProperty("crBranch")
    private String crBranch;

    @JsonProperty("crProfitCentre")
    private String crProfitCentre;

    @JsonProperty("crSeqNo")
    private Integer crSeqNo;

    @JsonProperty("crSettleMtd")
    private String crSettleMtd;

    @JsonProperty("crBaseEquiv")
    private BigDecimal crBaseEquiv;

    // ---------- Charges / rates ----------

    @JsonProperty("dtlDebitAmount")
    private BigDecimal dtlDebitAmount;

    @JsonProperty("drChargeAmount")
    private BigDecimal drChargeAmount;

    @JsonProperty("drExchRate")
    private BigDecimal drExchRate;

    @JsonProperty("drExchQuote")
    private String drExchQuote;

    @JsonProperty("dtlCreditAmount")
    private BigDecimal dtlCreditAmount;

    @JsonProperty("crChargeAmount")
    private BigDecimal crChargeAmount;

    @JsonProperty("crExchRate")
    private BigDecimal crExchRate;

    @JsonProperty("crExchQuote")
    private String crExchQuote;

    @JsonProperty("rateType")
    private String rateType;

    @JsonProperty("kondorRefNo")
    private String kondorRefNo;

    @JsonProperty("spotRate")
    private BigDecimal spotRate;

    @JsonProperty("spotQuote")
    private String spotQuote;

    // ---------- Booking / channel ----------

    @JsonProperty("acctExec")
    private String acctExec;

    @JsonProperty("bookBranch")
    private String bookBranch;

    @JsonProperty("incRefNo")
    private String incRefNo;

    @JsonProperty("channel")
    private String channel;

    @JsonProperty("channelSource")
    private String channelSource;

    @JsonProperty("channelRefNo")
    private String channelRefNo;

    @JsonProperty("narrative")
    private String narrative;

    @JsonProperty("rejectReason")
    private String rejectReason;

    @JsonProperty("errorCodeMsg")
    private String errorCodeMsg;

    @JsonProperty("variableSymbol")
    private String variableSymbol;

    @JsonProperty("constantSymbol")
    private String constantSymbol;

    @JsonProperty("specificSymbol")
    private String specificSymbol;

    @JsonProperty("tranTime")
    private String tranTime;

    @JsonProperty("tranClass")
    private String tranClass;

    @JsonProperty("origSpotRate")
    private BigDecimal origSpotRate;

    @JsonProperty("srcProgramId")
    private String srcProgramId;

    @JsonProperty("firstUserId")
    private String firstUserId;

    @JsonProperty("lastUserId")
    private String lastUserId;

    @JsonProperty("verifiedBy")
    private String verifiedBy;

    @JsonProperty("drSwfSettleKey")
    private String drSwfSettleKey;

    @JsonProperty("crSwfSettleKey")
    private String crSwfSettleKey;

    @JsonProperty("paymentOrdDetailRec")
    private Object paymentOrdDetailRec;

    @JsonProperty("paymentsChargesList")
    private List<Object> paymentsChargesList;

    @JsonProperty("crCommonSettleNostroMt202Rec")
    private Object crCommonSettleNostroMt202Rec;

    @JsonProperty("crCommonSettleNostroMt200Rec")
    private Object crCommonSettleNostroMt200Rec;

    @JsonProperty("drCommonSettleNostroMt210Rec")
    private Object drCommonSettleNostroMt210Rec;

    @JsonProperty("rbRestrSeqNo")
    private Integer rbRestrSeqNo;

    // ---------- Audit / framework ----------

    @JsonProperty("version")
    private Integer version;

    @JsonProperty("bizVersion")
    private Integer bizVersion;

    @JsonProperty("createdBy")
    private String createdBy;

    @JsonProperty("createdDt")
    private String createdDt;

    @JsonProperty("journalDt")
    private String journalDt;

    @JsonProperty("journalNo")
    private Long journalNo;

    @JsonProperty("modifiedBy")
    private String modifiedBy;

    @JsonProperty("modifiedDt")
    private String modifiedDt;

    @JsonProperty("virtualAttributeList")
    private List<Object> virtualAttributeList;

    @JsonProperty("dataExtensionList")
    private List<Object> dataExtensionList;

    @JsonProperty("header")
    private TopUpHeader header;

    @JsonProperty("securityHint")
    private String securityHint;

    @JsonProperty("digitalSignature")
    private String digitalSignature;

    @JsonProperty("hasNextYn")
    private String hasNextYn;

    @JsonProperty("messageInfoList")
    private List<Object> messageInfoList;

    @JsonProperty("hasError")
    private Boolean hasError;

    @JsonProperty("publicKey")
    private String publicKey;

    @JsonProperty("lastSuccessfulValidation")
    private String lastSuccessfulValidation;

    @JsonProperty("changeSummary")
    private String changeSummary;

}
