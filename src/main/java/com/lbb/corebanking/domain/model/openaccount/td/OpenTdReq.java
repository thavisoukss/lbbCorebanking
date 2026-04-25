package com.lbb.corebanking.domain.model.openaccount.td;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class OpenTdReq {
    private String acctType;
    private String clientNo;
    private String acctDesc;
    private String branch;
    private String ccy;
    private String ownershipType;
    private String acctOpenDate;

    private String profitCentre;
    private String clientInd;
    private String officerId;
    private String stmtPbk;

    private IntDetailRec intDetailRec;
    private AcctStmtRec acctStmtRec;
    private TdaRec tdaRec;

    // ===== toString JSON ===== //
    @Override
    public String toString() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.findAndRegisterModules(); // support OffsetDateTime
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            return mapper.writeValueAsString(this);
        } catch (Exception e) {
            return "Error converting to JSON: " + e.getMessage();
        }
    }
}
