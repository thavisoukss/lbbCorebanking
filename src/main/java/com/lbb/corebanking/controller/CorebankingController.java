package com.lbb.corebanking.controller;

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

    @PostMapping("/reversal")
    public ResponseEntity<ReversalRes> checkBalance(@RequestBody ReversalReq req) {
        return ResponseEntity.ok(coreBankingService.reversal(req));
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

    @PostMapping("/getStatementDetailIN")
    public ResponseEntity<StatementDetailInRes> getStatementDetailIn (@RequestBody StatementDetailInReq req) {
        return ResponseEntity.ok(coreBankingService.getStatementDetailIn(req));
    }

    @PostMapping("/getStatementDetailOut")
    public ResponseEntity<StatementDetailOutRes> getStatementDetailOut (@RequestBody StatementDetailOutReq req) {
        return ResponseEntity.ok(coreBankingService.getStatementDetailOut(req));
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

    @PostMapping("/openTDAccount")
    public OpenAccRes openTDAccount (@RequestBody OpenTdReq req) {
        logger.info(req);
        OpenAccRes result = new OpenAccRes();
        result = coreBankingService.openTDAccount(req);
        return result;
    }

    @PostMapping("/buyGoldFundTransfer")
    public BuyGoldTransferRes buyGoldFundTransfer (@RequestBody BuyGoldTransferReq req) {
        logger.info(req);
        BuyGoldTransferRes result = new BuyGoldTransferRes();
        result = coreBankingService.buyGoldTransferDate(req);
        return result;
    }

    @PostMapping("/internalTransfer")
    public TransferResponse internalTransfer (@RequestBody TransferRequest req) {
        logger.info(req);
        TransferResponse result = new TransferResponse();
        result = coreBankingService.internalTransferData(req);
        return result;
    }

    @PostMapping("/topup")
    public TopUpRes topup (@RequestBody TopUpReq req) {
        logger.info(req);
        TopUpRes result = new TopUpRes();
        result = coreBankingService.topUpDate(req);
        return result;
    }

    @PostMapping("/widthDraw")
    public BuyGoldTransferRes widthDraw (@RequestBody WidthDrawReq req) {
        logger.info(req);
        BuyGoldTransferRes result = new BuyGoldTransferRes();
        result = coreBankingService.widthDrawDate(req);
        return result;
    }
}
