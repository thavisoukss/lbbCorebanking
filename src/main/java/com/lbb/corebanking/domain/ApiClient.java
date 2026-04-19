package com.lbb.corebanking.domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApiClient {
    private static final Logger logger = LogManager.getLogger(ApiClient.class);
    private final RestTemplate restTemplate;

    public ApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public <T, R> R post(String url, T requestBody, HttpHeaders headers ,Class<R> responseType ) {
        logger.info("Calling External API: URL={}", url);

        HttpEntity<T> entity = new HttpEntity<>(requestBody, headers);

        try {
            logger.info("start call api open account request : {}", requestBody);


            R response = restTemplate.postForObject(url, entity, responseType);

            logger.info("end call api open account  response : {}", response);
            return response;

        } catch (org.springframework.web.client.ResourceAccessException e) {
            // ກໍລະນີ Timeout ຫຼື ເຊື່ອມຕໍ່ບໍ່ໄດ້
            logger.error("API Timeout or Connection Error: URL={}, Error={}", url, e.getMessage());
            throw new RuntimeException("External API service unavailable (Timeout)");

        } catch (org.springframework.web.client.HttpStatusCodeException e) {
            // ກໍລະນີ API ຕອບກັບມາເປັນ Error Status (4xx, 5xx)
            logger.error("API Error Status: {}, Response: {}", e.getStatusCode(), e.getResponseBodyAsString());
            throw e;

        } catch (Exception e) {
            logger.error("Unexpected API Error: {}", e.getMessage());
            throw e;
        }
    }


    public <R> R get(String url, HttpHeaders headers, Class<R> responseType) {
        logger.info("Calling External API (GET): URL={}", url);

        // ສ້າງ HttpEntity ໂດຍສົ່ງແຕ່ Header (ເພາະ GET ບໍ່ມີ Body)
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        try {


            ResponseEntity<R> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    responseType
            );

            logger.info("API Response Status: {}", response.getStatusCode());
            logger.info("API Response data: {}" ,response.getBody() );

           return response.getBody();


        } catch (org.springframework.web.client.ResourceAccessException e) {
            logger.error("API Timeout or Connection Error: URL={}, Error={}", url, e.getMessage());
            throw new RuntimeException("External API service unavailable (Timeout)");

        } catch (org.springframework.web.client.HttpStatusCodeException e) {
            logger.error("API Error Status: {}, Response: {}", e.getStatusCode(), e.getResponseBodyAsString());
            throw e;

        } catch (Exception e) {
            logger.error("Unexpected API Error: {}", e.getMessage());
            throw e;
        }
    }


    public <R> R getStatement(String url, HttpHeaders headers, Class<R> responseType) {
        logger.info("Calling External API  Statement (GET): URL={}", url);

        // ສ້າງ HttpEntity ໂດຍສົ່ງແຕ່ Header (ເພາະ GET ບໍ່ມີ Body)
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        try {

            // ໃຊ້ exchange ເພື່ອໃຫ້ສາມາດສົ່ງ HttpEntity (headers) ໄປນຳໄດ້
            ResponseEntity<R> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    responseType
            );

//            ResponseEntity<String> response = restTemplate.exchange(
//                    url,
//                    HttpMethod.GET,
//                    entity,
//                    String.class
//            );

            logger.info("API Response Status: {}", response.getStatusCode());
            logger.info("API Response data: {}",response.getBody());
            return response.getBody();


        } catch (org.springframework.web.client.ResourceAccessException e) {
            logger.error("API Timeout or Connection Error: URL={}, Error={}", url, e.getMessage());
            throw new RuntimeException("External API service unavailable (Timeout)");

        } catch (org.springframework.web.client.HttpStatusCodeException e) {
            logger.error("API Error Status: {}, Response: {}", e.getStatusCode(), e.getResponseBodyAsString());
            throw e;

        } catch (Exception e) {
            logger.error("Unexpected API Error: {}", e.getMessage());
            throw e;
        }
    }

}
