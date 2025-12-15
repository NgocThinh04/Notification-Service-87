package com.example.Notification.Service._7.mapper;

import com.example.Notification.Service._7.dto.NotificationDto;
import com.example.Notification.Service._7.entity.Notification;
import org.springframework.stereotype.Component;

@Component
public class NotificationMapper {
    public NotificationDto toDto(Notification notification){
        if(notification == null) return null;
        return new NotificationDto(
                notification.getNotificationId(),
                notification.getUserId(),
                notification.getTitle(),
                notification.getMessage(),
                notification.getType(),
                notification.getSentAt()
        );
    }

    public Notification toEntity(NotificationDto notificationDto){
        if(notificationDto == null) return null;
        return new Notification(
          notificationDto.getNotificationId(),
          notificationDto.getUserId(),
          notificationDto.getTitle(),
          notificationDto.getMessage(),
          notificationDto.getType(),
          notificationDto.getSentAt()
        );
    }
}
