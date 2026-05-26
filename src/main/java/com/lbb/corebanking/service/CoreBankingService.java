package com.lbb.corebanking.service;

import com.lbb.corebanking.controller.CorebankingController;
import com.lbb.corebanking.domain.ApiClient;
import com.lbb.corebanking.domain.model.buygold.BuyGoldPaymentOrdDetailRec;
import com.lbb.corebanking.domain.model.checkBalance.GetBalanceReq;
import com.lbb.corebanking.domain.model.checkBalance.GetBalanceRes;
import com.lbb.corebanking.domain.model.exchangerate.ApiResponse;
import com.lbb.corebanking.domain.model.exchangerate.ExchangeRateReq;
import com.lbb.corebanking.domain.model.buygold.BuyGoldTransferReq;
import com.lbb.corebanking.domain.model.buygold.BuyGoldTransferRes;
import com.lbb.corebanking.domain.model.fundtransfer.TransferDetail;
import com.lbb.corebanking.domain.model.fundtransfer.TransferRequest;
import com.lbb.corebanking.domain.model.fundtransfer.TransferResponse;
import com.lbb.corebanking.domain.model.openaccount.OpenAccountReq;
import com.lbb.corebanking.domain.model.openaccount.OpenAccountRes;
import com.lbb.corebanking.domain.model.openaccount.td.OpenAccRes;
import com.lbb.corebanking.domain.model.openaccount.td.OpenTdReq;
import com.lbb.corebanking.domain.model.reversal.ReversalReq;
import com.lbb.corebanking.domain.model.reversal.ReversalRes;
import com.lbb.corebanking.domain.model.runbatch.RunBatchRes;
import com.lbb.corebanking.domain.model.statement.StatementReq;
import com.lbb.corebanking.domain.model.statement.StatementRes;
import com.lbb.corebanking.domain.model.statementdeailin.StatementDetailInReq;
import com.lbb.corebanking.domain.model.statementdeailin.StatementDetailInRes;
import com.lbb.corebanking.domain.model.statmentdetialout.StatementDetailOutReq;
import com.lbb.corebanking.domain.model.statmentdetialout.StatementDetailOutRes;
import com.lbb.corebanking.domain.model.termdeposit.TermDepositInqueryReq;
import com.lbb.corebanking.domain.model.termdeposit.TermDepositInqueryRes;
import com.lbb.corebanking.domain.model.topup.PaymentOrdDetailRec;
import com.lbb.corebanking.domain.model.topup.TopUpReq;
import com.lbb.corebanking.domain.model.topup.TopUpRes;
import com.lbb.corebanking.domain.model.widthdraw.WidthDrawOrderCustomerStructRecord;
import com.lbb.corebanking.domain.model.widthdraw.WidthDrawPaymentOrderDetailRecord;
import com.lbb.corebanking.domain.model.widthdraw.WidthDrawReq;
import com.lbb.corebanking.domain.model.widthdraw.WidthDrawRes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoreBankingService {
    private static final Logger logger = LogManager.getLogger(CoreBankingService.class);

    private final ApiClient apiClient;

    @Value("${external.api.core-banking.url}")
    private String baseUrl;
    @Value("${external.api.core-banking.x-api-key}")
    private String apikey;
    @Value("${external.api.core-banking.token}")
    private String token;


    public CoreBankingService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public GetBalanceRes getBalance (GetBalanceReq req) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-api-key", apikey);
        headers.setBearerAuth(token);
        // 1. ສ້າງ URL ທີ່ມີ Query Parameters
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path("/dep/acctdashboardinfobal")
                .pathSegment(req.getAccount()) // ໃສ່ Account No ເຂົ້າໄປເປັນ Path
                .build()
                .toUriString();
        System.out.println(url);
        // ເອີ້ນໃຊ້ຜ່ານ ApiClient ທີ່ມາດຕະຖານ
        return apiClient.get(url, headers , GetBalanceRes.class );
    }

    public OpenAccountRes openAccount (OpenAccountReq req){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-api-key", apikey);
        headers.setBearerAuth(token);
        String url = baseUrl+"/dep/acct";

        return apiClient.post(url, req ,headers , OpenAccountRes.class );
    }

    public TermDepositInqueryRes termDepositInquery (TermDepositInqueryReq req){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-api-key", apikey);
        headers.setBearerAuth(token);

        String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path("/dep/accttd")
                .pathSegment(req.getAccount())
                .build()
                .toUriString();
        System.out.println(url);
        // ເອີ້ນໃຊ້ຜ່ານ ApiClient ທີ່ມາດຕະຖານ
        return apiClient.get(url, headers , TermDepositInqueryRes.class );
    }

    public StatementRes getStatement (StatementReq req){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-api-key", apikey);
        headers.setBearerAuth(token);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path("/dep/tranhist");

//        String endDate = req.getEndDate() != null
//                ? req.getEndDate()
//                : LocalDate.now().toString();
//
//        String startDate = req.getStartDate() != null
//                ? req.getStartDate()
//                : LocalDate.now().minusYears(1).toString();


        if (req.getLimit() != null) {
            builder.queryParam("limit", req.getLimit());
        }
        if (req.getOffset() != null) {
            builder.queryParam("offset", req.getOffset());
        }
        if (req.getAcctNo() != null) {
            builder.queryParam("acctNo", req.getAcctNo());
        }
        if (req.getSort() != null) {
            builder.queryParam("sort", req.getSort());
        }
        if (req.getCcy() != null) {
            builder.queryParam("ccy", req.getCcy());
        }
            builder.queryParam("startDt", req.getStartDate());

            builder.queryParam("endDt", req.getEndDate());

        String url = builder.build().toUriString();
        System.out.println(url);

        return apiClient.getStatement(url, headers , StatementRes.class );
    }

    public StatementDetailInRes getStatementDetailIn (StatementDetailInReq req){
            StatementDetailInRes result = new StatementDetailInRes();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("x-api-key", apikey);
            headers.setBearerAuth(token);

            String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                    .path("/dep/tranhist/{seqNo}")
                    .buildAndExpand(req.getRef())
                    .toUriString();
            logger.info(url);
            result = apiClient.getStatementDetailIn(url, headers , StatementDetailInRes.class );
            logger.info(result);
            return result;
    }

    public StatementDetailOutRes  getStatementDetailOut (StatementDetailOutReq req){
        // ກວດສອບ input
        if (req == null || req.getRef() == null || req.getDate() == null) {
            throw new IllegalArgumentException("Reference number and date are required");
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-api-key", apikey);
        headers.setBearerAuth(token);

        // Format: INT0000060003480~2025-05-21
        String data = req.getRef() + "~" + req.getDate();

        logger.info("Request - ref: {}, date: {}", req.getRef(), req.getDate());

        String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path("/gft/internaltransfers/" + data)
                .build(false)
                .toUriString();

        logger.info("Calling API: {}", url);

        StatementDetailOutRes result = apiClient.getStatementDetailOut(
                url,
                headers,
                StatementDetailOutRes.class
        );

        logger.info("Response received: {}",
                result != null ? "success" : "null");

        return result;
    }


    public ReversalRes reversal (ReversalReq req){

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.set("x-api-key", apikey);
    headers.setBearerAuth(token);
    String url = baseUrl+"/dep/ReversalTran";

    return apiClient.reversal(url, req ,headers , ReversalRes.class );

}

    public ApiResponse getExchange (ExchangeRateReq req){
        ApiResponse result = new ApiResponse();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-api-key", apikey);
        headers.setBearerAuth(token);

        String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path("/csd/xrate")
                .queryParam("branch", req.getBranch())
                .queryParam("ccy", req.getCcy())
                .queryParam("historyYn", false)
                .queryParam("xrateType", req.getXrateType())
                .build()
                .toUriString();
               return  apiClient.get(url, headers , ApiResponse.class );
    }

    public OpenAccRes openTDAccount (OpenTdReq req){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-api-key", apikey);
        headers.setBearerAuth(token);
        String url = baseUrl+"/dep/accttd";

        return apiClient.post(url, req ,headers , OpenAccRes.class );
    }

    public BuyGoldTransferRes buyGoldTransfer (BuyGoldTransferReq req){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-api-key", apikey);
        headers.setBearerAuth(token);
        String url = baseUrl+"/gft/internaltransfers";

        return apiClient.post(url, req ,headers , BuyGoldTransferRes.class );
    }

    public TransferResponse internalTransfer (TransferRequest req){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-api-key", apikey);
        headers.setBearerAuth(token);
        String url = baseUrl+"/dep/transfertransaction";

        return apiClient.internalTransfer(url, req ,headers , TransferResponse.class );
    }

    public TopUpRes topup (TopUpReq req){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-api-key", apikey);
        headers.setBearerAuth(token);
        String url = baseUrl+"/gft/internaltransfers";

        return apiClient.topup(url, req ,headers , TopUpRes.class );
    }


    public BuyGoldTransferRes widthDraw (WidthDrawReq req){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-api-key", apikey);
        headers.setBearerAuth(token);
        String url = baseUrl+"/gft/internaltransfers";

        return apiClient.widthDraw(url, req ,headers , BuyGoldTransferRes.class );
    }

    public RunBatchRes getDateBatch (){

        ApiResponse result = new ApiResponse();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-api-key", apikey);
        headers.setBearerAuth(token);

        String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path("/csd/coreregistryqry")
                .build()
                .toUriString();
        return  apiClient.get(url, headers , RunBatchRes.class );

    }

    public BuyGoldTransferRes buyGoldTransferDate (BuyGoldTransferReq req){
        BuyGoldTransferRes result = new BuyGoldTransferRes();
        BuyGoldTransferReq data = new BuyGoldTransferReq();
        BuyGoldPaymentOrdDetailRec paymentOrdDetailRec = new BuyGoldPaymentOrdDetailRec();
        paymentOrdDetailRec = req.getPaymentOrdDetailRec();
        paymentOrdDetailRec.setTranDate(getDate());

        data.setTranStatus(req.getTranStatus());
        data.setTranSource(req.getTranSource());
        data.setTranType(req.getTranType());
        data.setTranDate(getDate());
        data.setTranCountry(req.getTranCountry());
        data.setTotalDrAmount(req.getTotalDrAmount());
        data.setTotalCrAmount(req.getTotalCrAmount());
        data.setInstructedCcy(req.getInstructedCcy());
        data.setInstructedAmount(req.getInstructedAmount());
        data.setInstructedDate(getDate());
        data.setFixedSide(req.getFixedSide());
        data.setDrValueDate(getDate());
        data.setDrClientNo(req.getDrClientNo());
        data.setDrGlType(req.getDrGlType());
        data.setDrGlCode(req.getDrGlCode());
        data.setDrBranch(req.getDrBranch());
        data.setDrProfitCentre(req.getDrProfitCentre());
        data.setDrSeqNo(req.getDrSeqNo());
        data.setDrCcy(req.getDrCcy());
        data.setDrAmount(req.getDrAmount());
        data.setDrSettleMtd(req.getDrSettleMtd());
        data.setDrBaseEquiv(req.getDrBaseEquiv());
        data.setCrValueDate(getDate());
        data.setCrCcy(req.getCrCcy());
        data.setCrAmount(req.getCrAmount());
        data.setCrClientNo(req.getCrClientNo());
        data.setCrGlType(req.getCrGlType());
        data.setCrAcctNo(req.getCrAcctNo());
        data.setCrBranch(req.getCrBranch());
        data.setCrProfitCentre(req.getCrProfitCentre());
        data.setCrSeqNo(req.getCrSeqNo());
        data.setCrSettleMtd(req.getCrSettleMtd());
        data.setCrBaseEquiv(req.getCrBaseEquiv());
        data.setDtlDebitAmount(req.getDtlDebitAmount());
        data.setDrExchRate(req.getDrExchRate());
        data.setDtlCreditAmount(req.getDtlCreditAmount());
        data.setCrExchRate(req.getCrExchRate());
        data.setRateType(req.getRateType());
        data.setSpotRate(req.getSpotRate());
        data.setSpotQuote(req.getSpotQuote());
        data.setBookBranch(req.getBookBranch());
        data.setChannel(req.getChannel());
        data.setChannelSource(req.getChannelSource());
        data.setTranClass(req.getTranClass());
        data.setSrcProgramId(req.getSrcProgramId());
        data.setPaymentOrdDetailRec(req.getPaymentOrdDetailRec());
        return buyGoldTransfer(data);
    }

    public TransferResponse internalTransferData (TransferRequest req){

        TransferRequest dataReq = new TransferRequest();
        List<TransferDetail> dataList = new ArrayList<>();
        TransferDetail data = new TransferDetail();

        dataReq.setAcctNo(req.getAcctNo());
        dataReq.setTransferMode(req.getTransferMode());
        dataReq.setCheckTellerLimit(req.getCheckTellerLimit());
        dataReq.setDebitTranType(req.getDebitTranType());
        dataReq.setCreditTranType(req.getCreditTranType());


        data.setAcctNo(req.getAcctNo());
        data.setCpartyAcctNo(req.getTfrDetailList().get(0).getCpartyAcctNo());
        data.setCpartyAcctCcy(req.getTfrDetailList().get(0).getCpartyAcctCcy());
        data.setCpartyAcctStatus(req.getTfrDetailList().get(0).getCpartyAcctStatus());
        data.setEffectDate(getDate());
        data.setCpartyAvailBal(req.getTfrDetailList().get(0).getCpartyAvailBal());
        data.setCpartyLedgerBal(req.getTfrDetailList().get(0).getCpartyLedgerBal());
        data.setRemCcy(req.getTfrDetailList().get(0).getRemCcy());
        data.setAmount(req.getTfrDetailList().get(0).getAmount());
        data.setEquivAmount(req.getTfrDetailList().get(0).getEquivAmount());
        data.setDrNarrative(req.getTfrDetailList().get(0).getDrNarrative());
        data.setCrossRate(req.getTfrDetailList().get(0).getCrossRate());
        data.setTranDate(getDate());
        data.setBranch(req.getTfrDetailList().get(0).getBranch());
        dataList.add(data);
        dataReq.setTfrDetailList(dataList);

        return internalTransfer(dataReq);
    }

    public TopUpRes topUpDate (TopUpReq req){

        TopUpReq data = new TopUpReq();
        PaymentOrdDetailRec paymentOrdDetail = new PaymentOrdDetailRec();
        paymentOrdDetail = req.getPaymentOrdDetailRec();
        paymentOrdDetail.setTranDate(getDate());

        data.setTranStatus(req.getTranStatus());
        data.setTranSource(req.getTranSource());
        data.setTranType(req.getTranType());
        data.setTranDate(getDate());
        data.setTranCountry(req.getTranCountry());
        data.setTotalDrAmount(req.getTotalDrAmount());
        data.setTotalCrAmount(req.getTotalCrAmount());
        data.setInstructedCcy(req.getInstructedCcy());
        data.setInstructedAmount(req.getInstructedAmount());
        data.setInstructedDate(getDate());
        data.setFixedSide(req.getFixedSide());
        data.setDrValueDate(getDate());
        data.setDrClientNo(req.getDrClientNo());
        data.setDrGlType(req.getDrGlType());
        data.setDrGlCode(req.getDrGlCode());
        data.setDrBranch(req.getDrBranch());
        data.setDrProfitCentre(req.getDrProfitCentre());
        data.setDrSeqNo(req.getDrSeqNo());
        data.setDrCcy(req.getDrCcy());
        data.setDrAmount(req.getDrAmount());
        data.setDrSettleMtd(req.getDrSettleMtd());
        data.setDrBaseEquiv(req.getDrBaseEquiv());
        data.setCrValueDate(req.getCrValueDate());
        data.setCrCcy(req.getCrCcy());
        data.setCrAmount(req.getCrAmount());
        data.setCrClientNo(req.getCrClientNo());
        data.setCrGlType(req.getCrGlType());
        data.setCrAcctNo(req.getCrAcctNo());
        data.setCrBranch(req.getCrBranch());
        data.setCrProfitCentre(req.getCrProfitCentre());
        data.setCrSeqNo(req.getCrSeqNo());
        data.setCrSettleMtd(req.getCrSettleMtd());
        data.setCrBaseEquiv(req.getCrBaseEquiv());
        data.setDtlDebitAmount(req.getDtlDebitAmount());
        data.setDrExchRate(req.getDrExchRate());
        data.setDtlCreditAmount(req.getDtlCreditAmount());
        data.setCrExchRate(req.getCrExchRate());
        data.setRateType(req.getRateType());
        data.setSpotRate(req.getSpotRate());
        data.setSpotQuote(req.getSpotQuote());
        data.setBookBranch(req.getBookBranch());
        data.setChannel(req.getChannel());
        data.setChannelSource(req.getChannelSource());
        data.setTranClass(req.getTranClass());
        data.setSrcProgramId(req.getSrcProgramId());


        data.setPaymentOrdDetailRec(req.getPaymentOrdDetailRec());

     return topup(data) ;
    }

    public BuyGoldTransferRes widthDrawDate (WidthDrawReq req){

        WidthDrawReq request = new WidthDrawReq();
        WidthDrawPaymentOrderDetailRecord paymentOrderDetailRecord = new WidthDrawPaymentOrderDetailRecord();

        paymentOrderDetailRecord = req.getPaymentOrdDetailRec();
        paymentOrderDetailRecord.setTranDate(getDate());
        paymentOrderDetailRecord.setOrdCustomerStructRec(req.getPaymentOrdDetailRec().getOrdCustomerStructRec());

        request.setTranStatus(req.getTranStatus());
        request.setTranSource(req.getTranSource());
        request.setTranType(req.getTranType());
        request.setTranDate(getDate());
        request.setTranCountry(req.getTranCountry());
        request.setTotalDrAmount(req.getTotalDrAmount());
        request.setTotalCrAmount(req.getTotalCrAmount());
        request.setNarrative(req.getNarrative());

        // Map instructed fields
        request.setInstructedCcy(req.getInstructedCcy());
        request.setInstructedAmount(req.getInstructedAmount());
        request.setInstructedDate(getDate());
        request.setFixedSide(req.getFixedSide());

        // Map debit side fields
        request.setDrValueDate(getDate());
        request.setDrClientNo(req.getDrClientNo());
        request.setDrGlType(req.getDrGlType());
        request.setDrAcctNo(req.getDrAcctNo());
        request.setDrBranch(req.getDrBranch());
        request.setDrProfitCentre(req.getDrProfitCentre());
        request.setDrSeqNo(req.getDrSeqNo());
        request.setDrCcy(req.getDrCcy());
        request.setDrAmount(req.getDrAmount());
        request.setDrSettleMtd(req.getDrSettleMtd());
        request.setDrBaseEquiv(req.getDrBaseEquiv());
        request.setDrExchRate(req.getDrExchRate());
        request.setDtlDebitAmount(req.getDtlDebitAmount());

        // Map credit side fields
        request.setCrValueDate(getDate());
        request.setCrCcy(req.getCrCcy());
        request.setCrAmount(req.getCrAmount());
        request.setCrClientNo(req.getCrClientNo());
        request.setCrGlType(req.getCrGlType());
        request.setCrGlCode(req.getCrGlCode());
        request.setCrBranch(req.getCrBranch());
        request.setCrProfitCentre(req.getCrProfitCentre());
        request.setCrSeqNo(req.getCrSeqNo());
        request.setCrSettleMtd(req.getCrSettleMtd());
        request.setCrBaseEquiv(req.getCrBaseEquiv());
        request.setCrExchRate(req.getCrExchRate());
        request.setDtlCreditAmount(req.getDtlCreditAmount());
        request.setRateType(req.getRateType());
        request.setSpotRate(req.getSpotRate());
        request.setSpotQuote(req.getSpotQuote());
        request.setBookBranch(req.getBookBranch());
        request.setChannel(req.getChannel());
        request.setChannelSource(req.getChannelSource());
        request.setTranClass(req.getTranClass());
        request.setSrcProgramId(req.getSrcProgramId());
        request.setPaymentOrdDetailRec(paymentOrderDetailRecord);
        return widthDraw(request) ;
    }

    public String getDate(){
        RunBatchRes date = new RunBatchRes();
        date = getDateBatch();

       // String input = "2025-11-04T00:00:00.000+07:00";

        OffsetDateTime odt = OffsetDateTime.parse(date.getDetails().getData().get(0).getRunDate());

        return odt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX"));
    }






}
