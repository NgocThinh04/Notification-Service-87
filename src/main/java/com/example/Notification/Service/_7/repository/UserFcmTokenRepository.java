package com.example.Notification.Service._7.repository;

import com.example.Notification.Service._7.entity.UserFcmToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserFcmTokenRepository extends JpaRepository<UserFcmToken, Long> {
    List<UserFcmToken> findByUserId(Long userId);
    // Optional<UserFcmToken> findByuserIdAndfcmtoken(Long userId, Long tokenId);
    Optional<UserFcmToken> findByDeviceId(String deviceId);
    // boolean existsByuserIdAndfcmtoken(Long userId, Long fcmToken);
    void deleteByFcmToken(String fcmToken);
}
