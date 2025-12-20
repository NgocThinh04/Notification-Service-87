package com.example.Notification.Service._7.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequest {
    private Long userId;
    private String deviceId;

    public UserRequest() {

    }
}
