package com.example.Notification.Service._7.events;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
// Dinh nghia cau truc du lieu kafka
public class FcmTokenEvent {
    private String deviceId;
    private String fcmToken;
    private FcmTokenEvent(int deviceId,String fcmToken){

    }
}
