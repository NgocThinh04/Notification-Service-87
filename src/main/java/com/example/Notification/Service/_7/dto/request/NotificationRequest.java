package com.example.Notification.Service._7.dto.request;

import lombok.Data;

@Data
public class NotificationRequest {
    private String title;
    private String body;
    private String fcmToken;
    private NotificationRequest(String title, String body,String fcmToken) {

    }
}
