package com.lbb.corebanking.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "api_log")
@Data
@NoArgsConstructor
public class ApiLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "trace_id", length = 64)
    private String traceId;

    @Column(name = "span_id", length = 64)
    private String spanId;

    @Column(name = "method", length = 10)
    private String method;

    @Column(name = "path", length = 500)
    private String path;

    @Column(name = "request_body", columnDefinition = "CLOB")
    private String requestBody;

    @Column(name = "response_body", columnDefinition = "CLOB")
    private String responseBody;

    @Column(name = "response_code")
    private Integer responseCode;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name = "duration_ms")
    private Long durationMs;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
