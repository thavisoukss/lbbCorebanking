package com.lbb.corebanking.domain.model.statementdeailin;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.OffsetDateTime;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private OffsetDateTime creationTime;

    private String typeName;
    private String channelSource;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private OffsetDateTime channelTranDt;

    private Boolean resend;
    private String requestUri;
    private Boolean hasAuthToken;

}
