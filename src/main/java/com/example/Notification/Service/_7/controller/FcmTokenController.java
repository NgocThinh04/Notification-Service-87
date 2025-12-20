package com.example.Notification.Service._7.controller;

import com.example.Notification.Service._7.dto.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Notification.Service._7.dto.request.FcmTokenRequest;
import com.example.Notification.Service._7.service.FcmTokenService;

 @RestController
 @RequestMapping("/api/user")
 public class FcmTokenController {
     @Autowired
     private FcmTokenService fcmTokenService;
     // client send
     @PostMapping("/fcmtoken/client")
     public ResponseEntity<?> saveFcmtoken(@RequestBody FcmTokenRequest fcmTokenRequest) {
         fcmTokenService.saveOrUpdate(fcmTokenRequest);
         return ResponseEntity.ok(fcmTokenService);
     }
     // service authen
     @PostMapping("/bind")
     public ResponseEntity<Void> updateUserId(@RequestBody UserRequest userRequest) {
         fcmTokenService.saveUserId(userRequest);
         return ResponseEntity.ok().build();
     }
 }
