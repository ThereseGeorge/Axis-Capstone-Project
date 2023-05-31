package com.ani.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ani.project.domain.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule,Long>{
    
}