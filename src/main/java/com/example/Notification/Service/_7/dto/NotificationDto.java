package com.example.Notification.Service._7.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
public class NotificationDto {
    public NotificationDto(Long notificationId,Long userId,String title,String message,String type,LocalDateTime sentAt) {
        this.notificationId = notificationId;
        this.userId = userId;
        this.title = title;
        this.message = message;
        this.type = type;
        this.sentAt = sentAt;
    }
    private Long notificationId;
    private Long userId;
    private String title;
    private String message;
    private String type;
    private LocalDateTime sentAt;
}
