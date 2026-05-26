package com.lbb.corebanking.domain.model.reversal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Client Information
 * Contains information about the client making the request
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
