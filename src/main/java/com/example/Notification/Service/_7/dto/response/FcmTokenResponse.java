package com.example.Notification.Service._7.dto.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class FcmTokenResponse {
    private Long tokenId;
    private Integer userId;
    private String fcmToken;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
