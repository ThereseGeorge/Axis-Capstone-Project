package com.ani.project.util;

import org.springframework.stereotype.Component;

import com.ani.project.domain.Notification;
import com.ani.project.dto.NotificationDto;

@Component
public class NotificationMapper {
    
    public Notification toDomain(NotificationDto dto){
        return Notification.builder().date(dto.getDate()).notification(dto.getNotification()).build();

    }

    public NotificationDto toDto(Notification domain){
        return new NotificationDto(domain.getId(), domain.getDate(), domain.getNotification());
    }
}
