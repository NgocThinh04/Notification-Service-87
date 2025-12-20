 package com.example.Notification.Service._7.controller;

 import com.example.Notification.Service._7.service.FcmTokenService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;

 @RestController
 @RequestMapping("/api/booking")
 public class NotificationController {
     @Autowired
     private FcmTokenService fcmTokenService;
 }
