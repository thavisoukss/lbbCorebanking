package com.lbb.corebanking.domain.model.statmentdetialout;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentsCharge {


    private String refNo;
    private Long seqNo;

    private String tranDate;

    private String valueDate;

    private String ourBenInd;
    private String chargeType;
    private String scRateType;
    private String calcMethod;
    private String updatable;
    private String calcCcy;
    private BigDecimal baseForCalc;
    private String chargeCcy;
    private BigDecimal chargeCcyAmt;
    private String tranCcy;
    private BigDecimal tranCcyAmt;
    private BigDecimal scTaxAmtStandard;
    private String rbAcctNo;
    private BigDecimal scTaxAmt;
    private String quoteType;
    private String calcBalType;
    private String scReasonType;
    private BigDecimal baseEquiv;
    private String scReasonDesc;
    private BigDecimal chargeCcyAmtOrig;
    private String scMode;
    private String changedFlag;
    private BigDecimal exchRate;
    private BigDecimal origTranCcyAmt;
    private BigDecimal totalCreditChargeAmount;
    private BigDecimal totalDebitChargeAmount;
    private BigDecimal scTaxRate;
    private String scTaxType;
    private String scTaxTranType;
    private String scTranType;

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
