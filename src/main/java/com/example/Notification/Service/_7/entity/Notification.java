package com.example.Notification.Service._7.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id")
    private Long notificationId;

    @Column(name = "user_id",nullable = false)
    private Long userId;

    @Column(name = "title")
    private String title;

    @Column(name = "message")
    private String message;

    @Column(name = "type")
    private String type;

    @Column(name = "sent_at")
    private LocalDateTime sentAt;
    
    public  Notification(){

    }

    public Notification(Long notificationId, Long userId, String title, String message, String type, LocalDateTime sentAt) {
    }
}

