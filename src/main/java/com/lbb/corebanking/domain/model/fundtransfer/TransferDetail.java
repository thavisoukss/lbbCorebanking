package com.lbb.corebanking.domain.model.fundtransfer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferDetail {
    /** Source CA gold account number (ເລກບັນຊີ CA ຄຳ ຕົ້ນທາງ). */
    @JsonProperty("acctNo")
    private String acctNo;

    /** Counterparty (destination) CA gold account number (ປາຍທາງ). */
    @JsonProperty("cpartyAcctNo")
    private String cpartyAcctNo;

    /** Counterparty account currency, e.g. "LBI". */
    @JsonProperty("cpartyAcctCcy")
    private String cpartyAcctCcy;

    /** Counterparty account status, e.g. "A". */
    @JsonProperty("cpartyAcctStatus")
    private String cpartyAcctStatus;

    /** Effect date of the transfer. */
    @JsonProperty("effectDate")
    private String effectDate;

    /** Counterparty available balance. */
    @JsonProperty("cpartyAvailBal")
    private BigDecimal cpartyAvailBal;

    /** Counterparty ledger balance. */
    @JsonProperty("cpartyLedgerBal")
    private BigDecimal cpartyLedgerBal;

    /** Remit currency flag. */
    @JsonProperty("remCcy")
    private Boolean remCcy;

    /** Amount of gold to transfer (ຈຳນວນຄຳທີ່ຈະໂອນ). */
    @JsonProperty("amount")
    private BigDecimal amount;

    /** Equivalent amount of gold to transfer (ຈຳນວນຄຳທີ່ຈະໂອນ). */
    @JsonProperty("equivAmount")
    private BigDecimal equivAmount;

    /** Debit narrative / description, e.g. "CIF 2000987 P2P CIF 2000717". */
    @JsonProperty("drNarrative")
    private String drNarrative;

    /** Cross rate applied to the transfer. */
    @JsonProperty("crossRate")
    private BigDecimal crossRate;

    /** Transaction date. */
    @JsonProperty("tranDate")
    private String tranDate;

    /** Branch code, e.g. "100". */
    @JsonProperty("branch")
    private String branch;
}
