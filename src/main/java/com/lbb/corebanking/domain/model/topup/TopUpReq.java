package com.lbb.corebanking.domain.model.topup;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TopUpReq {
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

    @JsonProperty("drGlCode")
    private String drGlCode;

    @JsonProperty("drBranch")
    private String drBranch;

    @JsonProperty("drProfitCentre")
    private String drProfitCentre;

    @JsonProperty("drSeqNo")
    private String drSeqNo;

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

    @JsonProperty("crBranch")
    private String crBranch;

    @JsonProperty("crProfitCentre")
    private String crProfitCentre;

    @JsonProperty("crSeqNo")
    private String crSeqNo;

    @JsonProperty("crSettleMtd")
    private String crSettleMtd;

    @JsonProperty("crBaseEquiv")
    private BigDecimal crBaseEquiv;

    // ---------- Rates / detail amounts ----------

    @JsonProperty("dtlDebitAmount")
    private BigDecimal dtlDebitAmount;

    @JsonProperty("drExchRate")
    private BigDecimal drExchRate;

    @JsonProperty("dtlCreditAmount")
    private BigDecimal dtlCreditAmount;

    @JsonProperty("crExchRate")
    private BigDecimal crExchRate;

    @JsonProperty("rateType")
    private String rateType;

    @JsonProperty("spotRate")
    private BigDecimal spotRate;

    @JsonProperty("spotQuote")
    private String spotQuote;

    // ---------- Booking / channel ----------

    @JsonProperty("bookBranch")
    private String bookBranch;

    @JsonProperty("channel")
    private String channel;

    @JsonProperty("channelSource")
    private String channelSource;

    @JsonProperty("tranClass")
    private String tranClass;

    @JsonProperty("srcProgramId")
    private String srcProgramId;

    @JsonProperty("paymentOrdDetailRec")
    private PaymentOrdDetailRec paymentOrdDetailRec;

}
