package com.lbb.corebanking.domain.model.fundtransfer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.Data;

@Data
public class BuyGoldTransferReq {

    private String tranStatus;
    private String tranSource;
    private String tranType;
    private String tranDate;
    private String tranCountry;

    private String totalDrAmount;
    private String totalCrAmount;

    private String instructedCcy;
    private String instructedAmount;
    private String instructedDate;

    private String fixedSide;

    private String drValueDate;
    private String drClientNo;
    private String drGlType;
    private String drGlCode;
    private String drBranch;
    private String drProfitCentre;
    private String drSeqNo;
    private String drCcy;
    private String drAmount;
    private String drSettleMtd;
    private String drBaseEquiv;

    private String crValueDate;
    private String crCcy;
    private String crAmount;
    private String crClientNo;
    private String crGlType;
    private String crAcctNo;
    private String crBranch;
    private String crProfitCentre;
    private String crSeqNo;
    private String crSettleMtd;
    private String crBaseEquiv;

    private String dtlDebitAmount;
    private String drExchRate;
    private String dtlCreditAmount;
    private String crExchRate;

    private String rateType;
    private String spotRate;
    private String spotQuote;

    private String bookBranch;
    private String channel;
    private String channelSource;
    private String tranClass;
    private String srcProgramId;

    private PaymentOrdDetailRec paymentOrdDetailRec;


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
