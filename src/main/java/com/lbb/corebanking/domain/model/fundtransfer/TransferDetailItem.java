package com.lbb.corebanking.domain.model.fundtransfer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransferDetailItem {

    @JsonProperty("seqNo")
    private Long seqNo;

    @JsonProperty("acctNo")
    private String acctNo;

    @JsonProperty("cpartyAcctNo")
    private String cpartyAcctNo;

    @JsonProperty("cpartyAcctDesc")
    private String cpartyAcctDesc;

    @JsonProperty("cpartyAcctCcy")
    private String cpartyAcctCcy;

    @JsonProperty("cpartyAcctBranch")
    private String cpartyAcctBranch;

    @JsonProperty("cpartyAcctStatus")
    private String cpartyAcctStatus;

    @JsonProperty("cpartyAvailBal")
    private BigDecimal cpartyAvailBal;

    @JsonProperty("cpartyLedgerBal")
    private BigDecimal cpartyLedgerBal;

    @JsonProperty("effectDate")
    private String effectDate;

    @JsonProperty("remCcy")
    private Boolean remCcy;

    @JsonProperty("amount")
    private BigDecimal amount;

    @JsonProperty("equivAmount")
    private BigDecimal equivAmount;

    @JsonProperty("drNarrative")
    private String drNarrative;

    @JsonProperty("crNarrative")
    private String crNarrative;

    @JsonProperty("quoteType")
    private String quoteType;

    @JsonProperty("crossRate")
    private BigDecimal crossRate;

    @JsonProperty("rateReferenceId")
    private String rateReferenceId;

    @JsonProperty("rateOrigin")
    private String rateOrigin;

    @JsonProperty("tranDate")
    private String tranDate;

    @JsonProperty("branch")
    private String branch;

    @JsonProperty("origCrossRate")
    private BigDecimal origCrossRate;

    @JsonProperty("drSeqNo")
    private Long drSeqNo;

    @JsonProperty("crSeqNo")
    private Long crSeqNo;

    @JsonProperty("availBal")
    private BigDecimal availBal;

    @JsonProperty("ledgerBal")
    private BigDecimal ledgerBal;

    @JsonProperty("drFeeApplyList")
    private List<Object> drFeeApplyList;

    @JsonProperty("crFeeApplyList")
    private List<Object> crFeeApplyList;

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
    private ResponseHeader header;

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
