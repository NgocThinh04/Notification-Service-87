package com.example.Notification.Service._7.dto.response;

import lombok.Data;

@Data
public class NotificationResponse {
    private int status;
    private String message;

    public NotificationResponse(int value, String s) {
    }
}
