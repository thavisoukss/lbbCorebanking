package com.lbb.corebanking.config;

import com.lbb.corebanking.service.ApiLogService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpStatusCodeException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);

    private final ApiLogService apiLogService;

    public GlobalExceptionHandler(ApiLogService apiLogService) {
        this.apiLogService = apiLogService;
    }

    @ExceptionHandler(HttpStatusCodeException.class)
    public ResponseEntity<String> handleHttpStatusCodeException(HttpStatusCodeException e, HttpServletRequest request) {
        logger.error("External API error | status: {} | body: {}", e.getStatusCode(), e.getResponseBodyAsString());
        apiLogService.save(request, e.getResponseBodyAsString(), e.getStatusCode().value());
        return ResponseEntity
                .status(e.getStatusCode())
                .body(e.getResponseBodyAsString());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException e, HttpServletRequest request) {
        logger.error("Service error: {}", e.getMessage());
        String body = "{\"message\":\"" + e.getMessage() + "\"}";
        apiLogService.save(request, body, HttpStatus.SERVICE_UNAVAILABLE.value());
        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(body);
    }
}
