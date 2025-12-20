package com.example.Notification.Service._7.events;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DataEvent {
    private String type;
    private String message;
}
