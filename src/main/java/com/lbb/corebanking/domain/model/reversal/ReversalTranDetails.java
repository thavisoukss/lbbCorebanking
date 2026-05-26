package com.lbb.corebanking.domain.model.reversal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * Reversal Transaction Details
 * Contains detailed information about the reversal transaction
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReversalTranDetails {

    @JsonProperty("seqNo")
    private Long seqNo;

    @JsonProperty("tranDate")
    private OffsetDateTime tranDate;

    @JsonProperty("revTranSeqNo")
    private Long revTranSeqNo;

    @JsonProperty("revContraTranSeqNo")
    private Long revContraTranSeqNo;

    @JsonProperty("version")
    private Integer version;

    @JsonProperty("bizVersion")
    private Integer bizVersion;

    @JsonProperty("createdBy")
    private String createdBy;

    @JsonProperty("createdDt")
    private OffsetDateTime createdDt;

    @JsonProperty("journalDt")
    private OffsetDateTime journalDt;

    @JsonProperty("journalNo")
    private Long journalNo;

    @JsonProperty("modifiedBy")
    private String modifiedBy;

    @JsonProperty("modifiedDt")
    private OffsetDateTime modifiedDt;

    @JsonProperty("virtualAttributeList")
    private List<Object> virtualAttributeList;

    @JsonProperty("dataExtensionList")
    private List<Object> dataExtensionList;

    @JsonProperty("header")
    private RequestHeader header;

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
