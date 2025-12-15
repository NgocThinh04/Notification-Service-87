package com.example.Notification.Service._7.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "user_fcm_tokens",
        uniqueConstraints = {
                @UniqueConstraint(name = "uniq_user_token", columnNames = {"user_id", "fcm_token"})
        }
)
@Data
public class UserFcmToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "token_id")
    private Long tokenId;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "fcm_token",nullable = false)
    private String fcmToken;

    @Column(name = "device_id")
    private String deviceId;
    
    @Column(name = "created_at")

    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private LocalDateTime updatedAt;

    public UserFcmToken() {

    }
    public UserFcmToken(Long userId, String fcmToken) {

    }
}
