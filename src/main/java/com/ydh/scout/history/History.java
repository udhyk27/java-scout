package com.ydh.scout.history;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "collect_history")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "target_id", nullable = false)
    private Long targetId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private CollectStatus status;

    @Column(name = "http_status")
    private Integer httpStatus;

    @Column(name = "response_time_ms")
    private Integer responseTimeMs;

    @Column(name = "saved_file_path", length = 500)
    private String savedFilePath;

    @Column(name = "error_message", length = 1000)
    private String errorMessage;

    @CreationTimestamp
    @Column(name = "collected_at", updatable = false)
    private LocalDateTime collectedAt;

    @Builder
    public History(Long targetId, CollectStatus status, Integer httpStatus,
                   Integer responseTimeMs, String savedFilePath, String errorMessage) {
        this.targetId = targetId;
        this.status = status;
        this.httpStatus = httpStatus;
        this.responseTimeMs = responseTimeMs;
        this.savedFilePath = savedFilePath;
        this.errorMessage = errorMessage;
    }
}
