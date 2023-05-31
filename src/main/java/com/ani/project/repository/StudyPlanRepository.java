package com.ani.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ani.project.domain.StudyPlan;

public interface StudyPlanRepository extends JpaRepository<StudyPlan,Long>{
    
}
