package com.lbb.corebanking.service;

import com.lbb.corebanking.domain.entity.ApiLog;
import com.lbb.corebanking.repository.ApiLogRepository;
import io.micrometer.tracing.Span;
import io.micrometer.tracing.Tracer;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
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

    // Runs in request thread — captures span context and request data before async handoff
    public void save(HttpServletRequest request, String responseBody, int responseCode) {
        LocalDateTime startTime = (LocalDateTime) request.getAttribute("_startTime");
        Long startMs = (Long) request.getAttribute("_startMs");
        String requestBody = (String) request.getAttribute("_requestBody");
        String method = request.getMethod();
        String path = request.getRequestURI();
        LocalDateTime endTime = LocalDateTime.now();
        long durationMs = startMs != null ? System.currentTimeMillis() - startMs : 0;

        String traceId;
        String spanId;
        Span currentSpan = tracer.currentSpan();
        if (currentSpan != null) {
            traceId = currentSpan.context().traceId();
            spanId = currentSpan.context().spanId();
        } else if (request.getHeader("X-B3-TraceId") != null) {
            // fallback: read from B3 propagation headers sent by upstream service
            traceId = request.getHeader("X-B3-TraceId");
            spanId = request.getHeader("X-B3-SpanId");
        } else {
            // last fallback: use self-generated UUID when no tracing context available
            traceId = (String) request.getAttribute("_requestId");
            spanId = null;
        }

        persistLog(traceId, spanId, method, path, requestBody, responseBody, responseCode, startTime, endTime, durationMs);
    }

    // Runs in background thread — only uses pre-captured data, no thread-local access
    @Async
    public void persistLog(String traceId, String spanId, String method, String path,
                           String requestBody, String responseBody, int responseCode,
                           LocalDateTime startTime, LocalDateTime endTime, long durationMs) {
        try {
            ApiLog log = new ApiLog();
            log.setTraceId(traceId);
            log.setSpanId(spanId);
            log.setMethod(method);
            log.setPath(path);
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
