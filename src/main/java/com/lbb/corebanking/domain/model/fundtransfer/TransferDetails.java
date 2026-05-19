package com.lbb.corebanking.domain.model.fundtransfer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransferDetails {

    @JsonProperty("seqNo")
    private Long seqNo;

    @JsonProperty("acctNo")
    private String acctNo;

    @JsonProperty("transferMode")
    private String transferMode;

    @JsonProperty("debitTranType")
    private String debitTranType;

    @JsonProperty("creditTranType")
    private String creditTranType;

    @JsonProperty("ignoreRestraint")
    private String ignoreRestraint;

    @JsonProperty("ignoreAvailbal")
    private String ignoreAvailbal;

    @JsonProperty("checkOverride")
    private String checkOverride;

    @JsonProperty("checkTellerLimit")
    private String checkTellerLimit;

    @JsonProperty("checkEffdate")
    private String checkEffdate;

    @JsonProperty("tfrDetailList")
    private List<TransferDetailItem> tfrDetailList;

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
