package com.ani.project.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ani.project.domain.Notification;
import com.ani.project.dto.NotificationDto;
import com.ani.project.exception.NotificationNotFoundException;
import com.ani.project.repository.NotificationRepository;
import com.ani.project.util.NotificationMapper;

import lombok.AllArgsConstructor;

@Transactional
@AllArgsConstructor
@Service
public class NotificationServiceImpl implements NotificationService{
    
    public final NotificationRepository repository;
    public final NotificationMapper mapper;


    @Override
    public Integer createNewNotification(NotificationDto dto) {
        // TODO Auto-generated method stub
        repository.save(mapper.toDomain(dto));
        return 1;
    }


    @Override
    public List<NotificationDto> all() {
        // TODO Auto-generated method stub
        return repository.findAll().stream().map(mapper :: toDto).collect(Collectors.toList());
    }


    @Override
    public Integer deleteNotification(Long id) {
        // TODO Auto-generated method stub
        repository.deleteById(id);
        return 1;
    }


    @Override
    public NotificationDto fetchNotificationDetails(Long id) {
        // TODO Auto-generated method stub
        Optional<Notification> op = repository.findById(id);
        return mapper.toDto(op.orElseThrow(() -> new NotificationNotFoundException("Notification" + id + "Not Found")));
    }


    @Override
    public Integer updateNotification(NotificationDto dto) {
        // TODO Auto-generated method stub
        Long id= dto.getId();
        Notification notification= repository.findById(id).orElseThrow(() -> new NotificationNotFoundException("Notification not found"));
        notification.setDate(dto.getDate());
        notification.setNotification(dto.getNotification());
        repository.save(notification);

    
        return 1;
    }

}