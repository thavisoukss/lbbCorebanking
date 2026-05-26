package com.lbb.corebanking.domain.model.fundtransfer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.Data;

import java.util.List;

@Data
public class TransferRequest {

    private String acctNo;

    private String transferMode;

    /** Debit transaction type, e.g. "TRW2" / "TRD2". */
    private String debitTranType;

    /** Credit transaction type, e.g. "TRD2" / "TRW2". */
    private String creditTranType;

    /** Whether to check teller limit ("Y" / "N"). */
    private String checkTellerLimit;

    /** List of transfer details (one entry per counterparty). */
    private List<TransferDetail> tfrDetailList;

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
