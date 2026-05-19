package com.lbb.corebanking.domain.model.topup;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentOrdDetailRec {

    @JsonProperty("tranDate")
    private String tranDate;

    @JsonProperty("tranSource")
    private String tranSource;

    @JsonProperty("ordCustomerStructRec")
    private OrdCustomerStructRec ordCustomerStructRec;
}
