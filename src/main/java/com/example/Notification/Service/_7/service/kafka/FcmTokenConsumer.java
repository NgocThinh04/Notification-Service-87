package com.example.Notification.Service._7.service.kafka;

import com.example.Notification.Service._7.dto.request.FcmTokenRequest;
import com.example.Notification.Service._7.dto.request.UserRequest;
import com.example.Notification.Service._7.entity.UserFcmToken;
import com.example.Notification.Service._7.events.DeviceEvent;
import com.example.Notification.Service._7.events.FcmTokenEvent;
import com.example.Notification.Service._7.repository.UserFcmTokenRepository;
import com.example.Notification.Service._7.service.impl.FcmTokenImpl;

import com.google.firebase.ErrorCode;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class FcmTokenConsumer {
    @Autowired
    private UserFcmTokenRepository userFcmTokenRepository;
    private final FcmTokenImpl fcmToken;
    private final FirebaseMessaging firebaseMessaging;
    @KafkaListener(
            topics = "device-token",
            containerFactory = "kafkaListenerContainerFactory",
            groupId = "fcm-notification-group" 
    )
    public void listenKafkaFcm(FcmTokenEvent event){
        System.out.println("fcm token:" + event);
        if(event == null) {
            return;
        }
        FcmTokenRequest request = new FcmTokenRequest();
        request.setToken(event.getFcmToken());
        request.setDeviceId(event.getDeviceId());

        fcmToken.saveOrUpdate(request);
    }
    @KafkaListener(
            topics = "user-token",
            containerFactory = "kafkaListenerContainerFactory",
            groupId = "device-group"
    )
    public void listenKafkaDevice(DeviceEvent deviceEvent){
        System.out.println("DeviceId + UserId + Body:" + deviceEvent);
        if(deviceEvent == null || deviceEvent.getUserId() == null) {
            return;
        }
        List<UserFcmToken> listFcmToken = userFcmTokenRepository.findByUserId(deviceEvent.getUserId());
        if(listFcmToken.isEmpty()) {
            log.info("Not found FCM Token");
            return;
        }
        for (UserFcmToken tokenEntity : listFcmToken) {
            String token = tokenEntity.getFcmToken();
            // Create message
            Message message = Message.builder()
                    .putData("type", deviceEvent.getBody().getType())
                    .putData("message", deviceEvent.getBody().getMessage())
                     .setNotification(Notification.builder()
                         .setTitle("Thông báo mới")
                         .setBody(deviceEvent.getBody().getMessage())
                         .build())
                    .setToken(token)
                    .build();
            try {
                firebaseMessaging.send(message);
                log.info("Send success to firebase");
            } catch (FirebaseMessagingException e) {
                if(e.getErrorCode() == ErrorCode.NOT_FOUND || e.getErrorCode() == ErrorCode.UNAVAILABLE || e.getErrorCode() == ErrorCode.INVALID_ARGUMENT || e.getMessage() != null && e.getMessage().contains("not registered")) {
                    log.info("Token not activity: {}", token.substring(0, 10) + "......");
                    userFcmTokenRepository.deleteByFcmToken(token);
                }
            }
        }
    }

}
