package com.example.Notification.Service._7.consumer;

//import com.example.Notification.Service._7.entity.UserFcmToken;
//import com.example.Notification.Service._7.events.AuthTokenEvent;
//import com.example.Notification.Service._7.repository.UserFcmTokenRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;

// @Component
// public class AuthTokenConsumer {
//     @Autowired
//     private UserFcmTokenRepository userFcmTokenRepository;
//     @KafkaListener(topics = "auth-token-events")
//     private void authToken(AuthTokenEvent event){
//         // User login: Auth Serive send {userId: fcmToken}
//         // Save database
//         UserFcmToken fcmToken = new UserFcmToken(
//                 event.getUserId(),
//                 event.getFcmtoken()
//         );
//         userFcmTokenRepository.save(fcmToken);
//     }
// }
