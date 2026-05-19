package com.lbb.corebanking.domain.model.fundtransfer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientInfo {
    @JsonProperty("sessionId")
    private String sessionId;

    @JsonProperty("wsId")
    private String wsId;

    @JsonProperty("remoteUserName")
    private String remoteUserName;

    @JsonProperty("hostName")
    private String hostName;

    @JsonProperty("ipAddress")
    private String ipAddress;

    @JsonProperty("macAddress")
    private String macAddress;

    @JsonProperty("securityDeviceNo")
    private String securityDeviceNo;

    @JsonProperty("addInfo")
    private String addInfo;
}
