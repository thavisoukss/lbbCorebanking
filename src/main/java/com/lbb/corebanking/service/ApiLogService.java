package com.lbb.corebanking.service;

import com.lbb.corebanking.domain.entity.ApiLog;
import com.lbb.corebanking.repository.ApiLogRepository;
import io.micrometer.tracing.Span;
import io.micrometer.tracing.Tracer;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ApiLogService {
    private static final Logger logger = LogManager.getLogger(ApiLogService.class);

    private final ApiLogRepository apiLogRepository;
    private final Tracer tracer;

    public ApiLogService(ApiLogRepository apiLogRepository, Tracer tracer) {
        this.apiLogRepository = apiLogRepository;
        this.tracer = tracer;
    }

    public void save(HttpServletRequest request, String responseBody, int responseCode) {
        try {
            LocalDateTime startTime = (LocalDateTime) request.getAttribute("_startTime");
            Long startMs = (Long) request.getAttribute("_startMs");
            String requestBody = (String) request.getAttribute("_requestBody");

            LocalDateTime endTime = LocalDateTime.now();
            long durationMs = startMs != null ? System.currentTimeMillis() - startMs : 0;

            String traceId = null;
            String spanId = null;
            Span currentSpan = tracer.currentSpan();
            if (currentSpan != null) {
                traceId = currentSpan.context().traceId();
                spanId = currentSpan.context().spanId();
            }

            ApiLog log = new ApiLog();
            log.setTraceId(traceId);
            log.setSpanId(spanId);
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
