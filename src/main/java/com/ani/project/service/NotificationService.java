package com.ani.project.service;

import java.util.List;

import com.ani.project.dto.NotificationDto;
import com.ani.project.exception.NotificationNotFoundException;

public interface NotificationService {
    
    Integer createNewNotification(NotificationDto notification);
    List<NotificationDto> all();
    Integer deleteNotification(Long id) throws NotificationNotFoundException;
    NotificationDto fetchNotificationDetails(Long id) throws NotificationNotFoundException;
    Integer updateNotification(NotificationDto notification);
    
}