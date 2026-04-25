package com.lbb.corebanking.domain.model.openaccount.td;

import lombok.Data;
import java.math.BigDecimal;
@Data
public class TdaRec {
    private BigDecimal principalAmt;
    private Integer depTermPeriod;
    private String depTermType;
    private String maturityDate;
    private String autoRenewRollover;

}
