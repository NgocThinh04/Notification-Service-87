package com.example.Notification.Service._7.service;

import java.util.concurrent.ExecutionException;

import com.example.Notification.Service._7.dto.request.FcmTokenRequest;

public interface NotificationService {
        void sendMessagaToToken(FcmTokenRequest notificationRequest) throws InterruptedException, ExecutionException;
}
