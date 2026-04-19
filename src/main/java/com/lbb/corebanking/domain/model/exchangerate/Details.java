package com.lbb.corebanking.domain.model.exchangerate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Details {
    private List<XRateData> data;
    private int total;
}
