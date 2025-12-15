// package com.example.Notification.Service._7.service.impl;

// import com.example.Notification.Service._7.events.FcmTokenEvent;
// import com.example.Notification.Service._7.mapper.FcmTokenMapper;
// import com.example.Notification.Service._7.mapper.NotificationMapper;
// import com.example.Notification.Service._7.repository.NotificationRepository;
// import com.example.Notification.Service._7.repository.UserFcmTokenRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// @Service
// public class NotificationServiceImpl  {
//     @Autowired
//     private NotificationRepository notificationRepository;
//     @Autowired
//     private NotificationMapper notificationMapper;
//     @Autowired 
//     private UserFcmTokenRepository userFcmTokenRepository;
//     @Autowired
//     private FcmTokenEvent authTokenEvent;
//     @Autowired
//     private FcmTokenMapper fcmTokenMapper;
//     // public UserFcmToken savefcmToken(FcmTokenRequest fcmTokenRequest) {
//     //     UserFcmToken userFcmToken = fcmTokenMapper.toEntity(fcmTokenRequest);
//     //     userFcmToken = userFcmTokenRepository.save(userFcmToken);
//     //     return fcmTokenMapper.toResponse(fcmTokenRequest);
//     // }
//     // public Notification createNotification(NotificationDto notificationDto){
//     //     Notification notification = notificationMapper.toEntity(notificationDto);
//     //     return notificationRepository.save(notification);
//     // }
// }