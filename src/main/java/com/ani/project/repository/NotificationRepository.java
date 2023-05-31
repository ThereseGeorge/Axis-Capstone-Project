package com.ani.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ani.project.domain.Notification;

public interface NotificationRepository extends JpaRepository<Notification,Long>{
    
}
