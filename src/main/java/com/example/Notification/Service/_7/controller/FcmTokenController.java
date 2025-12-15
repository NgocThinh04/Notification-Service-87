package com.example.Notification.Service._7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Notification.Service._7.dto.request.FcmTokenRequest;
import com.example.Notification.Service._7.service.FcmTokenService;

// @RestController
// @RequestMapping("/api")
// public class FcmTokenController {
//     @Autowired
//     private FcmTokenService fcmTokenService;
//     @PostMapping("/fcmtoken")
//     public ResponseEntity<?> saveFcmtoken(@RequestBody FcmTokenRequest fcmTokenRequest) {
//             // fcmTokenService saveFcmtoken(u);
//             // return ResponseEntity.ok
//     }
// }
