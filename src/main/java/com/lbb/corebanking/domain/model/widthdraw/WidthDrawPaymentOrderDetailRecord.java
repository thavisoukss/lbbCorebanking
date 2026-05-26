package com.lbb.corebanking.domain.model.widthdraw;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WidthDrawPaymentOrderDetailRecord {

    @JsonProperty("tranDate")
    private String tranDate;

    @JsonProperty("tranSource")
    private String tranSource;

    @JsonProperty("ordCustomerStructRec")
    private WidthDrawOrderCustomerStructRecord ordCustomerStructRec;
}
