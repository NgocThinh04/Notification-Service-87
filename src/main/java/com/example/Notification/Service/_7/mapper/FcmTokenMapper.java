package com.example.Notification.Service._7.mapper;

import org.mapstruct.Mapper;

import com.example.Notification.Service._7.dto.request.FcmTokenRequest;
import com.example.Notification.Service._7.dto.response.FcmTokenResponse;
import com.example.Notification.Service._7.entity.UserFcmToken;

@Mapper(componentModel = "spring")
public interface FcmTokenMapper {
    // Request to entity
    UserFcmToken toEntity(FcmTokenRequest fcmTokenRequest);
    // Entity to response
    FcmTokenResponse toResponse(UserFcmToken userFcmToken);
}
