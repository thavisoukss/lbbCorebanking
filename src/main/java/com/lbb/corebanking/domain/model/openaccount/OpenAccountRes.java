package com.lbb.corebanking.domain.model.openaccount;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.util.List;

@Data
public class OpenAccountRes {
    private String code;
    private String  status;
    private String responseType;
    private String message;
    private String journalNo;
    Detail details;
    List<WarningInfoList> warningInfoList;

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return "Error serializing to JSON: " + e.getMessage();
        }
    }
}
