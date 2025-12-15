// package com.example.Notification.Service._7.controller;

// import com.example.Notification.Service._7.service.FcmTokenService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// public class NotificationController {
//     @Autowired
//     private FcmTokenService fcmTokenService;
//     @PostMapping("/fcmtoken")
//     public ResponseEntity saveFcmtoken(@RequestBody FcmTokenRequest fcmTokenRequest) {
//         fcmTokenService saveFcmtoken(fcmTokenRequest);
//         return 
//     }
//     @PostMapping("/notification")
//     public ResponseEntity sendNotification(@RequestBody NotificationRequest request) throws ExecutionException, InterruptedException {
//         notificationServiceKafka.sendMessagaToToken(request);
//         return new ResponseEntity<>(new NotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
//     }
// }
