package com.lbb.corebanking.domain.model.openaccount.td;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class AcctStmtRec {

    private String consSc;
    private String stmtAfterMovement;
    private String stmtAtCap;
    private String suppressPrint;
    private String contactRefNo;
    private String clientName;
    private String address;
    private String onMaturityStmt;
    private String stmtHandling;
    private String periodFreq;

    private String nextStmtDate;

    private Integer stmtDay;
    private String stmtLang;

}
