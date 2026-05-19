package com.lbb.corebanking.service;

import com.lbb.corebanking.controller.CorebankingController;
import com.lbb.corebanking.domain.ApiClient;
import com.lbb.corebanking.domain.model.checkBalance.GetBalanceReq;
import com.lbb.corebanking.domain.model.checkBalance.GetBalanceRes;
import com.lbb.corebanking.domain.model.exchangerate.ApiResponse;
import com.lbb.corebanking.domain.model.exchangerate.ExchangeRateReq;
import com.lbb.corebanking.domain.model.buygold.BuyGoldTransferReq;
import com.lbb.corebanking.domain.model.buygold.BuyGoldTransferRes;
import com.lbb.corebanking.domain.model.fundtransfer.TransferRequest;
import com.lbb.corebanking.domain.model.fundtransfer.TransferResponse;
import com.lbb.corebanking.domain.model.openaccount.OpenAccountReq;
import com.lbb.corebanking.domain.model.openaccount.OpenAccountRes;
import com.lbb.corebanking.domain.model.openaccount.td.OpenAccRes;
import com.lbb.corebanking.domain.model.openaccount.td.OpenTdReq;
import com.lbb.corebanking.domain.model.runbatch.RunBatchRes;
import com.lbb.corebanking.domain.model.statement.StatementReq;
import com.lbb.corebanking.domain.model.statement.StatementRes;
import com.lbb.corebanking.domain.model.statementdeailin.StatementDetailInReq;
import com.lbb.corebanking.domain.model.statementdeailin.StatementDetailInRes;
import com.lbb.corebanking.domain.model.statmentdetialout.StatementDetailOutReq;
import com.lbb.corebanking.domain.model.statmentdetialout.StatementDetailOutRes;
import com.lbb.corebanking.domain.model.termdeposit.TermDepositInqueryReq;
import com.lbb.corebanking.domain.model.termdeposit.TermDepositInqueryRes;
import com.lbb.corebanking.domain.model.topup.TopUpReq;
import com.lbb.corebanking.domain.model.topup.TopUpRes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

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

        String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path("/dep/tranhist")
                .queryParam("limit",req.getLimit())
                .queryParam("offset",req.getOffset())
                .queryParam("acctNo",req.getAcctNo())
                .build()
                .toUriString();
        System.out.println(url);
        // ເອີ້ນໃຊ້ຜ່ານ ApiClient ທີ່ມາດຕະຖານ
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


}
