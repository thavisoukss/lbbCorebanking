package com.lbb.corebanking.domain.model.widthdraw;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.Data;

@Data
public class WidthDrawReq {


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
    private String totalDrAmount;

    @JsonProperty("totalCrAmount")
    private String totalCrAmount;

    @JsonProperty("narrative")
    private String narrative;

    @JsonProperty("instructedCcy")
    private String instructedCcy;

    @JsonProperty("instructedAmount")
    private String instructedAmount;

    @JsonProperty("instructedDate")
    private String instructedDate;

    @JsonProperty("fixedSide")
    private String fixedSide;

    // Debit side fields
    @JsonProperty("drValueDate")
    private String drValueDate;

    @JsonProperty("drClientNo")
    private String drClientNo;

    @JsonProperty("drGlType")
    private String drGlType;

    @JsonProperty("drAcctNo")
    private String drAcctNo;

    @JsonProperty("drBranch")
    private String drBranch;

    @JsonProperty("drProfitCentre")
    private String drProfitCentre;

    @JsonProperty("drSeqNo")
    private String drSeqNo;

    @JsonProperty("drCcy")
    private String drCcy;

    @JsonProperty("drAmount")
    private String drAmount;

    @JsonProperty("drSettleMtd")
    private String drSettleMtd;

    @JsonProperty("drBaseEquiv")
    private String drBaseEquiv;

    @JsonProperty("drExchRate")
    private String drExchRate;

    @JsonProperty("dtlDebitAmount")
    private String dtlDebitAmount;

    // Credit side fields
    @JsonProperty("crValueDate")
    private String crValueDate;

    @JsonProperty("crCcy")
    private String crCcy;

    @JsonProperty("crAmount")
    private String crAmount;

    @JsonProperty("crClientNo")
    private String crClientNo;

    @JsonProperty("crGlType")
    private String crGlType;

    @JsonProperty("crGlCode")
    private String crGlCode;

    @JsonProperty("crBranch")
    private String crBranch;

    @JsonProperty("crProfitCentre")
    private String crProfitCentre;

    @JsonProperty("crSeqNo")
    private String crSeqNo;

    @JsonProperty("crSettleMtd")
    private String crSettleMtd;

    @JsonProperty("crBaseEquiv")
    private String crBaseEquiv;

    @JsonProperty("crExchRate")
    private String crExchRate;

    @JsonProperty("dtlCreditAmount")
    private String dtlCreditAmount;

    // Rate and exchange fields
    @JsonProperty("rateType")
    private String rateType;

    @JsonProperty("spotRate")
    private String spotRate;

    @JsonProperty("spotQuote")
    private String spotQuote;

    // System fields
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
    private WidthDrawPaymentOrderDetailRecord paymentOrdDetailRec;


    // ===== toString JSON ===== //
    @Override
    public String toString() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.findAndRegisterModules(); // support OffsetDateTime
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            return mapper.writeValueAsString(this);
        } catch (Exception e) {
            return "Error converting to JSON: " + e.getMessage();
        }
    }
}
