package com.lbb.corebanking.domain.model.runbatch;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyData {


    private String coyName;
    private String coyShort;
    private String systemPhase;

    private String runDate;

    private String lastRunDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private OffsetDateTime lastFyeDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private OffsetDateTime nextRunDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private OffsetDateTime mthEndDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private OffsetDateTime yrEndDate;

    private String symChannel;
    private String symChannelSource;
    private String defaultBranch;
    private String baseCcy;
    private String localCcy;
    private String limitCcy;
    private Integer headOfficeClient;
    private String headOfficeClientPk;
    private String defaultCrRating;
    private String defaultProfitCentre;
    private String defaultRateType;
    private Integer version;
    private Integer bizVersion;
    private String createdBy;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private OffsetDateTime createdDt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private OffsetDateTime journalDt;

    private Long journalNo;
    private String modifiedBy;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private OffsetDateTime modifiedDt;

    private List<Object> virtualAttributeList;
    private List<Object> dataExtensionList;
    private Object header;
    private Object securityHint;
    private Object digitalSignature;
    private String hasNextYn;
    private List<Object> messageInfoList;
    private Boolean hasError;
    private String publicKey;
    private String lastSuccessfulValidation;
    private String changeSummary;
}
