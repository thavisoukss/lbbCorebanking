package com.lbb.corebanking.domain.model.widthdraw;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WidthDrawOrderCustomerStructRecord {

    @JsonProperty("address")
    private String address;

}
