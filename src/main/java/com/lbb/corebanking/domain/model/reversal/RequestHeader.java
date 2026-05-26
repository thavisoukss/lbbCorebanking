package com.lbb.corebanking.domain.model.reversal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * CBS Request Header
 * Contains metadata about the API request
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestHeader {

    @JsonProperty("serviceOperation")
    private String serviceOperation;

    @JsonProperty("applUserCode")
    private String applUserCode;

    @JsonProperty("organisationCode")
    private String organisationCode;

    @JsonProperty("userRoleList")
    private List<Object> userRoleList;

    @JsonProperty("dataChannelCode")
    private String dataChannelCode;

    @JsonProperty("langCode")
    private String langCode;

    @JsonProperty("corrId")
    private String corrId;

    @JsonProperty("screenNo")
    private String screenNo;

    @JsonProperty("bpmInfo")
    private String bpmInfo;

    @JsonProperty("clientInfo")
    private ClientInfo clientInfo;

    @JsonProperty("creationTime")
    private OffsetDateTime creationTime;

    @JsonProperty("typeName")
    private String typeName;

    @JsonProperty("channelSource")
    private String channelSource;

    @JsonProperty("channelTranDt")
    private OffsetDateTime channelTranDt;

    @JsonProperty("resend")
    private Boolean resend;

    @JsonProperty("requestUri")
    private String requestUri;

    @JsonProperty("hasAuthToken")
    private Boolean hasAuthToken;
}
