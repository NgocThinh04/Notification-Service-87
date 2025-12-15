// package com.example.Notification.Service._7.service.impl;

// import com.example.Notification.Service._7.dto.request.FcmTokenRequest;
// import com.example.Notification.Service._7.service.FcmTokenService;
// import com.google.firebase.messaging.*;
// import com.google.gson.Gson;
// import com.google.gson.GsonBuilder;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.stereotype.Service;

// import java.time.Duration;
// import java.util.concurrent.ExecutionException;


// @Service
// public class FCMService {
//     private Logger logger = LoggerFactory.getLogger(FCMService.class);

//     public void sendMessagaToToken(FcmTokenRequest notificationRequest) throws InterruptedException, ExecutionException {
//         Message message = getPreconfigureMessageToToken(notificationRequest);
//         Gson gson = new GsonBuilder().setPrettyPrinting().create();
//         String jsonOutput = gson.toJson(message);
//         String response = sendAndGetResponse(message);
//         logger.info("Sent message to token. Derive token:{}, {} msg {}", notificationRequest.getToken(), response, jsonOutput);

//     }
//     private String sendAndGetResponse(Message message) throws InterruptedException, ExecutionException {
//         return FirebaseMessaging.getInstance().sendAsync(message).get();
//     }

//     private AndroidConfig getAndroidConfig(String topic) {
//         return AndroidConfig.builder()
//                 .setTtl(Duration.ofMinutes(2).toMillis()).setCollapseKey(topic)
//                 .setPriority(AndroidConfig.Priority.HIGH)
//                 .setNotification(AndroidNotification.builder()
//                         .setTag(topic).build()).build();

//     }
//     private Message getPreconfigureMessageToToken(FcmTokenRequest notificationRequest){
//         return getPreconfiguredMessageBuilder(notificationRequest).setToken(notificationRequest.getToken()).build();
//     }
//     private Message.Builder getPreconfiguredMessageBuilder(FcmTokenRequest notificationRequest) {
//         AndroidConfig androidConfig = getAndroidConfig(notificationRequest.getTopic());
//         Notification notification = Notification.builder()
//                 .setTitle(notificationRequest.getTitle())
//                 .setBody(notificationRequest.getBody())
//                 .build();
//         return Message.builder()
//                 .setAndroidConfig(androidConfig).setNotification(notification);
//     }

// }
