package com.lbb.corebanking.domain.model.topup;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrdCustomerStructRec {
    @JsonProperty("address")
    private String address;


}
