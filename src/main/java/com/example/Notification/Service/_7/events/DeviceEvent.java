package com.example.Notification.Service._7.events;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceEvent {
    private String deviceId;
    private Long userId;
    private DataEvent body;
    public DeviceEvent(String deviceId,Long userId, DeviceEvent body){}
}
