package com.lbb.corebanking.domain.model.openaccount;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

@Data
public class OpenAccountReq {
    private String acctType;
    private String clientNo;
    private String clientShort;
    private String acctDesc;
    private String branch;
    private String ccy;
    private String ownershipType;
    private String acctOpenDate;
    private String profitCentre;
    private String officerId;

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return "Error serializing to JSON: " + e.getMessage();
        }
    }
}
