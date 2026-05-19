package com.lbb.corebanking.domain.model.statmentdetialout;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentOrdDetailRec {


    private String refNo;

    private String tranDate;

    private String tranSource;
    private String branchData;
    private String detailsOfChrg;

    private OrdCustomerStructRec ordCustomerStructRec;
    private Object ordBankStructRec;
    private Object intmdBankStructRec;
    private Object benBankStructRec;
    private Object benInstStructRec;
    private Object benCustomerStructRec;
    private DetailsOfPmtStructRec detailsOfPmtStructRec;
    private SenderToReceiverInfoStructRec senderToReceiverInfoStructRec;
    private Object regulatoryReportingStructRec;

    private Integer version;
    private Integer bizVersion;
    private String createdBy;

    private String createdDt;

    private String journalDt;

    private Long journalNo;
    private String modifiedBy;

    private String modifiedDt;

    private List<Object> virtualAttributeList;
    private List<Object> dataExtensionList;
    private Header header;
    private Object securityHint;
    private Object digitalSignature;
    private String hasNextYn;
    private List<Object> messageInfoList;
    private Boolean hasError;
    private String publicKey;
    private String lastSuccessfulValidation;
    private String changeSummary;
}
