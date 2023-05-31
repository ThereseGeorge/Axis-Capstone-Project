package com.ani.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ani.project.domain.Mark;

public interface MarkRepository extends JpaRepository<Mark,Long> {
    
}
