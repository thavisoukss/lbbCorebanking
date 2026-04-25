package com.lbb.corebanking.domain.model.openaccount.td;

import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class IntDetailRec {

    private BigDecimal crEffectiveRate;
    private String crIntType;
    private String crPeriodFreq;

    private String crNextCycleDate;

    private Integer crIntDay;
    private String tdRelationInd;
    private String crIntRateInd;
    private String crTdPayout;
    private String capOnDec31;
    private String crIntAcct;
    private String interestBonf;

}
