package com.lbb.corebanking.service;

import com.lbb.corebanking.domain.entity.ApiLog;
import com.lbb.corebanking.repository.ApiLogRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ApiLogService {
    private static final Logger logger = LogManager.getLogger(ApiLogService.class);

    private final ApiLogRepository apiLogRepository;

    public ApiLogService(ApiLogRepository apiLogRepository) {
        this.apiLogRepository = apiLogRepository;
    }

    public void save(HttpServletRequest request, String responseBody, int responseCode) {
        try {
            LocalDateTime startTime = (LocalDateTime) request.getAttribute("_startTime");
            Long startMs = (Long) request.getAttribute("_startMs");
            String requestBody = (String) request.getAttribute("_requestBody");

            LocalDateTime endTime = LocalDateTime.now();
            long durationMs = startMs != null ? System.currentTimeMillis() - startMs : 0;

            ApiLog log = new ApiLog();
            log.setTraceId(MDC.get("traceId"));
            log.setSpanId(MDC.get("spanId"));
            log.setMethod(request.getMethod());
            log.setPath(request.getRequestURI());
            log.setRequestBody(requestBody);
            log.setResponseBody(responseBody);
            log.setResponseCode(responseCode);
            log.setStartTime(startTime);
            log.setEndTime(endTime);
            log.setDurationMs(durationMs);

            apiLogRepository.save(log);
        } catch (Exception e) {
            logger.error("Failed to save API log to DB: {}", e.getMessage());
        }
    }
}
