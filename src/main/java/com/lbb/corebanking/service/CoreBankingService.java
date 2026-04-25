package com.lbb.corebanking.service;

import com.lbb.corebanking.domain.ApiClient;
import com.lbb.corebanking.domain.model.checkBalance.GetBalanceReq;
import com.lbb.corebanking.domain.model.checkBalance.GetBalanceRes;
import com.lbb.corebanking.domain.model.exchangerate.ApiResponse;
import com.lbb.corebanking.domain.model.exchangerate.ExchangeRateReq;
import com.lbb.corebanking.domain.model.exchangerate.ExchangeRateRes;
import com.lbb.corebanking.domain.model.fundtransfer.BuyGoldTransferReq;
import com.lbb.corebanking.domain.model.fundtransfer.BuyGoldTransferRes;
import com.lbb.corebanking.domain.model.openaccount.OpenAccountReq;
import com.lbb.corebanking.domain.model.openaccount.OpenAccountRes;
import com.lbb.corebanking.domain.model.openaccount.td.OpenAccRes;
import com.lbb.corebanking.domain.model.openaccount.td.OpenTdReq;
import com.lbb.corebanking.domain.model.statement.StatementReq;
import com.lbb.corebanking.domain.model.statement.StatementRes;
import com.lbb.corebanking.domain.model.termdeposit.TermDepositInqueryReq;
import com.lbb.corebanking.domain.model.termdeposit.TermDepositInqueryRes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class CoreBankingService {

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


}
