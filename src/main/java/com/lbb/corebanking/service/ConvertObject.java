package com.lbb.corebanking.service;

import com.lbb.corebanking.domain.model.exchangerate.ApiResponse;
import com.lbb.corebanking.domain.model.exchangerate.ExchangeRateData;
import com.lbb.corebanking.domain.model.exchangerate.ExchangeRateRes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class ConvertObject {

    private static final Logger logger = LogManager.getLogger(ConvertObject.class);

    public ExchangeRateRes convertExchange(ApiResponse req){
        ExchangeRateRes result = new ExchangeRateRes();
        ExchangeRateData data = new ExchangeRateData();

        data.setBuyRate(req.getDetails().getData().get(0).getBuyRate());
        data.setMidRate(req.getDetails().getData().get(0).getMidRate());
        data.setSellRate(req.getDetails().getData().get(0).getSellRate());

        result.setCode(req.getCode());
        result.setMessage(req.getMessage());
        result.setJournalNo(req.getJournalNo());
        result.setMessage(req.getMessage());
        result.setData(data);

        return result;
    }
}
