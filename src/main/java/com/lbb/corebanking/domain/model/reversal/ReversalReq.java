package com.lbb.corebanking.domain.model.reversal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * CBS API Response wrapper
 * Main response object for all CBS API calls
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReversalReq {

private long seqNo;
private String tranDate;
}
