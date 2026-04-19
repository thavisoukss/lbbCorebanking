package com.lbb.corebanking.controller;

import com.lbb.corebanking.domain.model.checkBalance.GetBalanceReq;
import com.lbb.corebanking.domain.model.checkBalance.GetBalanceRes;
import com.lbb.corebanking.domain.model.exchangerate.ApiResponse;
import com.lbb.corebanking.domain.model.exchangerate.ExchangeRateReq;
import com.lbb.corebanking.domain.model.exchangerate.ExchangeRateRes;
import com.lbb.corebanking.domain.model.openaccount.OpenAccountReq;
import com.lbb.corebanking.domain.model.openaccount.OpenAccountRes;
import com.lbb.corebanking.domain.model.statement.StatementReq;
import com.lbb.corebanking.domain.model.statement.StatementRes;
import com.lbb.corebanking.domain.model.termdeposit.TermDepositInqueryReq;
import com.lbb.corebanking.domain.model.termdeposit.TermDepositInqueryRes;
import com.lbb.corebanking.service.ConvertObject;
import com.lbb.corebanking.service.CoreBankingService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/corebanking")
public class CorebankingController {
    private static final Logger logger = LogManager.getLogger(CorebankingController.class);

    @Autowired
    CoreBankingService coreBankingService;

    @Autowired ConvertObject convertObject;

    @GetMapping("/test")
    public String  Test(){
        return "Test";
    }

    @PostMapping("/checkBalance")
    public ResponseEntity<GetBalanceRes> checkBalance(@RequestBody GetBalanceReq req) {
        return ResponseEntity.ok(coreBankingService.getBalance(req));
    }

    @PostMapping("/openAccount")
    public ResponseEntity<OpenAccountRes>openAccount (@RequestBody OpenAccountReq req) {
        return ResponseEntity.ok(coreBankingService.openAccount(req));
    }

    @PostMapping("/termAccountInquery")
    public ResponseEntity<TermDepositInqueryRes>termAccountInquery (@RequestBody TermDepositInqueryReq req) {
        return ResponseEntity.ok(coreBankingService.termDepositInquery(req));
    }

    @PostMapping("/getStatement")
    public ResponseEntity<StatementRes> getStatement (@RequestBody StatementReq req) {
        return ResponseEntity.ok(coreBankingService.getStatement(req));
    }

    @PostMapping("/getRate")
    public ExchangeRateRes getRate (@RequestBody ExchangeRateReq req) {
        logger.info(req);
        ApiResponse data = new ApiResponse();
        ExchangeRateRes result = new ExchangeRateRes();

        data = coreBankingService.getExchange(req);

        result = convertObject.convertExchange(data);
        return result;
    }
}
