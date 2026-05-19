package com.lbb.corebanking.domain.model.statmentdetialout;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Header {

    private String serviceOperation;
    private String applUserCode;
    private String organisationCode;
    private List<String> userRoleList;
    private String dataChannelCode;
    private String langCode;
    private String corrId;
    private String screenNo;
    private Object bpmInfo;
    private Object clientInfo;

    private String creationTime;

    private String typeName;
    private String channelSource;

    private String channelTranDt;

    private Boolean resend;
    private String requestUri;
    private Boolean hasAuthToken;
}
