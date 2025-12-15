package com.example.Notification.Service._7.repository;

import com.example.Notification.Service._7.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    Optional<Notification> findBynotificationId(Long notificationId);
}
