package com.example.Notification.Service._7.service;

import java.util.concurrent.ExecutionException;

import com.example.Notification.Service._7.dto.request.FcmTokenRequest;
import com.example.Notification.Service._7.dto.request.UserRequest;
import com.example.Notification.Service._7.entity.UserFcmToken;

public interface FcmTokenService {
    void saveOrUpdate(FcmTokenRequest fcmTokenRequest);
    void saveUserId(UserRequest userRequest);
}
