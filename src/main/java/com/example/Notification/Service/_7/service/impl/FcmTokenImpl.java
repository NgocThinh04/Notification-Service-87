package com.example.Notification.Service._7.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Notification.Service._7.dto.request.FcmTokenRequest;
import com.example.Notification.Service._7.entity.UserFcmToken;
import com.example.Notification.Service._7.mapper.NotificationMapper;
import com.example.Notification.Service._7.repository.NotificationRepository;
import com.example.Notification.Service._7.repository.UserFcmTokenRepository;
import com.example.Notification.Service._7.service.FcmTokenService;

import java.time.LocalDateTime;

@Service
public class FcmTokenImpl implements FcmTokenService{
    private final UserFcmTokenRepository userFcmTokenRepository;
    public FcmTokenImpl(UserFcmTokenRepository userFcmTokenRepository) {
        this.userFcmTokenRepository = userFcmTokenRepository;
    }
    @Transactional
    public void saveOrUpdate(String deviceId, String fcmToken) {
        UserFcmToken userFcmToken = userFcmTokenRepository.findByDeviceId(deviceId)
                .orElseGet(() -> {
                    UserFcmToken token = new UserFcmToken();
                    token.setTokenId(Long.valueOf(deviceId));
                    return token;
                });
        userFcmToken.setFcmToken(fcmToken);
        userFcmToken.setUpdatedAt(LocalDateTime.now());
        userFcmTokenRepository.save(userFcmToken);
    }
}