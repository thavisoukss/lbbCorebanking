package com.lbb.corebanking.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lbb.corebanking.domain.model.checkBalance.GetBalanceReq;
import com.lbb.corebanking.domain.model.checkBalance.GetBalanceRes;
import com.lbb.corebanking.domain.model.exchangerate.ApiResponse;
import com.lbb.corebanking.domain.model.exchangerate.ExchangeRateReq;
import com.lbb.corebanking.domain.model.exchangerate.ExchangeRateRes;
import com.lbb.corebanking.domain.model.buygold.BuyGoldTransferReq;
import com.lbb.corebanking.domain.model.buygold.BuyGoldTransferRes;
import com.lbb.corebanking.domain.model.fundtransfer.TransferRequest;
import com.lbb.corebanking.domain.model.fundtransfer.TransferResponse;
import com.lbb.corebanking.domain.model.openaccount.OpenAccountReq;
import com.lbb.corebanking.domain.model.openaccount.OpenAccountRes;
import com.lbb.corebanking.domain.model.openaccount.td.OpenAccRes;
import com.lbb.corebanking.domain.model.openaccount.td.OpenTdReq;
import com.lbb.corebanking.domain.model.reversal.ReversalReq;
import com.lbb.corebanking.domain.model.reversal.ReversalRes;
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
import com.lbb.corebanking.domain.model.widthdraw.WidthDrawReq;
import com.lbb.corebanking.service.ApiLogService;
import com.lbb.corebanking.service.ConvertObject;
import com.lbb.corebanking.service.CoreBankingService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/corebanking")
public class CorebankingController {
    private static final Logger logger = LogManager.getLogger(CorebankingController.class);

    @Autowired
    CoreBankingService coreBankingService;

    @Autowired
    ConvertObject convertObject;

    @Autowired
    ApiLogService apiLogService;

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("/test")
    public String Test() {
        return "Test";
    }

    @PostMapping("/checkBalance")
    public ResponseEntity<GetBalanceRes> checkBalance(@RequestBody GetBalanceReq req, HttpServletRequest request) {
        initLog(request, req);
        logger.info("******** start request | {} {}", request.getMethod(), request.getRequestURI());
        ResponseEntity<GetBalanceRes> result = ResponseEntity.ok(coreBankingService.getBalance(req));
        logger.info("******** end request   | {} {}", request.getMethod(), request.getRequestURI());
        apiLogService.save(request, toJson(result.getBody()), result.getStatusCode().value());
        return result;
    }

    @PostMapping("/reversal")
    public ResponseEntity<ReversalRes> reversal(@RequestBody ReversalReq req, HttpServletRequest request) {
        initLog(request, req);
        logger.info("******** start request | {} {}", request.getMethod(), request.getRequestURI());
        ResponseEntity<ReversalRes> result = ResponseEntity.ok(coreBankingService.reversal(req));
        logger.info("******** end request   | {} {}", request.getMethod(), request.getRequestURI());
        apiLogService.save(request, toJson(result.getBody()), result.getStatusCode().value());
        return result;
    }

    @PostMapping("/openAccount")
    public ResponseEntity<OpenAccountRes> openAccount(@RequestBody OpenAccountReq req, HttpServletRequest request) {
        initLog(request, req);
        logger.info("******** start request | {} {}", request.getMethod(), request.getRequestURI());
        ResponseEntity<OpenAccountRes> result = ResponseEntity.ok(coreBankingService.openAccount(req));
        logger.info("******** end request   | {} {}", request.getMethod(), request.getRequestURI());
        apiLogService.save(request, toJson(result.getBody()), result.getStatusCode().value());
        return result;
    }

    @PostMapping("/termAccountInquery")
    public ResponseEntity<TermDepositInqueryRes> termAccountInquery(@RequestBody TermDepositInqueryReq req, HttpServletRequest request) {
        initLog(request, req);
        logger.info("******** start request | {} {}", request.getMethod(), request.getRequestURI());
        ResponseEntity<TermDepositInqueryRes> result = ResponseEntity.ok(coreBankingService.termDepositInquery(req));
        logger.info("******** end request   | {} {}", request.getMethod(), request.getRequestURI());
        apiLogService.save(request, toJson(result.getBody()), result.getStatusCode().value());
        return result;
    }

    @PostMapping("/getStatement")
    public ResponseEntity<StatementRes> getStatement(@RequestBody StatementReq req, HttpServletRequest request) {
        initLog(request, req);
        logger.info("******** start request | {} {}", request.getMethod(), request.getRequestURI());
        ResponseEntity<StatementRes> result = ResponseEntity.ok(coreBankingService.getStatement(req));
        logger.info("******** end request   | {} {}", request.getMethod(), request.getRequestURI());
        apiLogService.save(request, toJson(result.getBody()), result.getStatusCode().value());
        return result;
    }

    @PostMapping("/getStatementDetailIN")
    public ResponseEntity<StatementDetailInRes> getStatementDetailIn(@RequestBody StatementDetailInReq req, HttpServletRequest request) {
        initLog(request, req);
        logger.info("******** start request | {} {}", request.getMethod(), request.getRequestURI());
        ResponseEntity<StatementDetailInRes> result = ResponseEntity.ok(coreBankingService.getStatementDetailIn(req));
        logger.info("******** end request   | {} {}", request.getMethod(), request.getRequestURI());
        apiLogService.save(request, toJson(result.getBody()), result.getStatusCode().value());
        return result;
    }

    @PostMapping("/getStatementDetailOut")
    public ResponseEntity<StatementDetailOutRes> getStatementDetailOut(@RequestBody StatementDetailOutReq req, HttpServletRequest request) {
        initLog(request, req);
        logger.info("******** start request | {} {}", request.getMethod(), request.getRequestURI());
        ResponseEntity<StatementDetailOutRes> result = ResponseEntity.ok(coreBankingService.getStatementDetailOut(req));
        logger.info("******** end request   | {} {}", request.getMethod(), request.getRequestURI());
        apiLogService.save(request, toJson(result.getBody()), result.getStatusCode().value());
        return result;
    }

    @PostMapping("/getRate")
    public ExchangeRateRes getRate(@RequestBody ExchangeRateReq req, HttpServletRequest request) {
        initLog(request, req);
        logger.info("******** start request | {} {}", request.getMethod(), request.getRequestURI());
        ApiResponse data = coreBankingService.getExchange(req);
        ExchangeRateRes result = convertObject.convertExchange(data);
        logger.info("******** end request   | {} {}", request.getMethod(), request.getRequestURI());
        apiLogService.save(request, toJson(result), 200);
        return result;
    }

    @PostMapping("/openTDAccount")
    public OpenAccRes openTDAccount(@RequestBody OpenTdReq req, HttpServletRequest request) {
        initLog(request, req);
        logger.info("******** start request | {} {}", request.getMethod(), request.getRequestURI());
        OpenAccRes result = coreBankingService.openTDAccount(req);
        logger.info("******** end request   | {} {}", request.getMethod(), request.getRequestURI());
        apiLogService.save(request, toJson(result), 200);
        return result;
    }

    @PostMapping("/buyGoldFundTransfer")
    public BuyGoldTransferRes buyGoldFundTransfer(@RequestBody BuyGoldTransferReq req, HttpServletRequest request) {
        initLog(request, req);
        logger.info("******** start request | {} {}", request.getMethod(), request.getRequestURI());
        BuyGoldTransferRes result = coreBankingService.buyGoldTransferDate(req);
        logger.info("******** end request   | {} {}", request.getMethod(), request.getRequestURI());
        apiLogService.save(request, toJson(result), 200);
        return result;
    }

    @PostMapping("/internalTransfer")
    public TransferResponse internalTransfer(@RequestBody TransferRequest req, HttpServletRequest request) {
        initLog(request, req);
        logger.info("******** start request | {} {}", request.getMethod(), request.getRequestURI());
        TransferResponse result = coreBankingService.internalTransferData(req);
        logger.info("******** end request   | {} {}", request.getMethod(), request.getRequestURI());
        apiLogService.save(request, toJson(result), 200);
        return result;
    }

    @PostMapping("/topup")
    public TopUpRes topup(@RequestBody TopUpReq req, HttpServletRequest request) {
        initLog(request, req);
        logger.info("******** start request | {} {}", request.getMethod(), request.getRequestURI());
        TopUpRes result = coreBankingService.topUpDate(req);
        logger.info("******** end request   | {} {}", request.getMethod(), request.getRequestURI());
        apiLogService.save(request, toJson(result), 200);
        return result;
    }

    @PostMapping("/widthDraw")
    public BuyGoldTransferRes widthDraw(@RequestBody WidthDrawReq req, HttpServletRequest request) {
        initLog(request, req);
        logger.info("******** start request | {} {}", request.getMethod(), request.getRequestURI());
        BuyGoldTransferRes result = coreBankingService.widthDrawDate(req);
        logger.info("******** end request   | {} {}", request.getMethod(), request.getRequestURI());
        apiLogService.save(request, toJson(result), 200);
        return result;
    }

    private void initLog(HttpServletRequest request, Object req) {
        request.setAttribute("_startTime", LocalDateTime.now());
        request.setAttribute("_startMs", System.currentTimeMillis());
        request.setAttribute("_requestBody", toJson(req));
    }

    private String toJson(Object obj) {
        try {
            return obj != null ? objectMapper.writeValueAsString(obj) : null;
        } catch (Exception e) {
            return obj != null ? obj.toString() : null;
        }
    }
}
