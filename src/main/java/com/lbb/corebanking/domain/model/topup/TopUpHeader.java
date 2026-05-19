package com.lbb.corebanking.domain.model.topup;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TopUpHeader {

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
    private Object clientInfo;

    @JsonProperty("creationTime")
    private String creationTime;

    @JsonProperty("typeName")
    private String typeName;

    @JsonProperty("channelSource")
    private String channelSource;

    @JsonProperty("channelTranDt")
    private String channelTranDt;

    @JsonProperty("resend")
    private Boolean resend;

    @JsonProperty("requestUri")
    private String requestUri;

    @JsonProperty("hasAuthToken")
    private Boolean hasAuthToken;

}
