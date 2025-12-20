package com.example.Notification.Service._7.service.impl;

import com.example.Notification.Service._7.dto.request.UserRequest;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import com.example.Notification.Service._7.dto.request.FcmTokenRequest;
import com.example.Notification.Service._7.entity.UserFcmToken;
import com.example.Notification.Service._7.repository.UserFcmTokenRepository;
import com.example.Notification.Service._7.service.FcmTokenService;
import java.util.Optional;

import java.time.LocalDateTime;

@Service
@Slf4j
public class FcmTokenImpl implements FcmTokenService{
    private final UserFcmTokenRepository userFcmTokenRepository;
    public FcmTokenImpl(UserFcmTokenRepository userFcmTokenRepository) {
        this.userFcmTokenRepository = userFcmTokenRepository;
    }
    @Transactional 
    public void saveOrUpdate(FcmTokenRequest fcmToken) {
        System.out.println("DeviceId: " + fcmToken.getDeviceId());
        Optional<UserFcmToken> findByDevice = userFcmTokenRepository.findByDeviceId(fcmToken.getDeviceId());
            if (findByDevice.isPresent()) {
            UserFcmToken existingToken = findByDevice.get();
            log.info("Found existing token for deviceId: {}", fcmToken.getDeviceId());
            if (!fcmToken.getToken().equals(existingToken.getFcmToken())) {
                log.info("Updating fcmToken from '{}' to '{}'", 
                         existingToken.getFcmToken(), fcmToken);
                existingToken.setFcmToken(fcmToken.getToken());
                existingToken.setUpdatedAt(LocalDateTime.now());
                userFcmTokenRepository.save(existingToken);
            } else {
                log.info("fcmToken unchanged, skipping update");
            }
            
        } else {
            log.info("Creating new token for deviceId: {}", fcmToken.getDeviceId());
            UserFcmToken newToken = new UserFcmToken();
            newToken.setDeviceId(fcmToken.getDeviceId());
            newToken.setFcmToken(fcmToken.getToken());
            newToken.setCreatedAt(LocalDateTime.now());
            newToken.setUpdatedAt(LocalDateTime.now());
            userFcmTokenRepository.save(newToken);
            log.info("Created new token with ID: {}", newToken.getTokenId());
        }
    }
    @Transactional
    public void saveUserId(UserRequest userRequest) {
        UserFcmToken token = userFcmTokenRepository
                .findByDeviceId(userRequest.getDeviceId())
                .orElseThrow(() ->
                        new IllegalStateException("Device not found: " + userRequest.getDeviceId())
                );
        if(userRequest.getUserId().equals(token.getUserId())) {
            return;
        }
        token.setUserId(userRequest.getUserId());
        token.setUpdatedAt(LocalDateTime.now());
    }
}