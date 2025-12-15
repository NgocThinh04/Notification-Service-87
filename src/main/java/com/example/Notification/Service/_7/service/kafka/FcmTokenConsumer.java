package com.example.Notification.Service._7.service.kafka;

import com.example.Notification.Service._7.events.FcmTokenEvent;
import com.example.Notification.Service._7.service.impl.FcmTokenImpl;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class FcmTokenConsumer {
    private final FcmTokenImpl fcmToken;

    public FcmTokenConsumer(FcmTokenImpl fcmToken){
        this.fcmToken = fcmToken;
    }
    @KafkaListener(
            topics = "device-token",
            containerFactory = "kafkaListenerContainerFactory",
            groupId = "fcm-notification-group"
    )
    public void listenKafka(FcmTokenEvent event){
        System.out.println("fcm token:" + event);
       fcmToken.saveOrUpdate(
               event.getDeviceId(),
               event.getFcmToken()
       );
    }
}
