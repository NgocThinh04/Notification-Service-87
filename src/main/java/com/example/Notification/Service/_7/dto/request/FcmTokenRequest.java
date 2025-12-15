package com.example.Notification.Service._7.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FcmTokenRequest {
    private String deviceId;
    private String token;
}
