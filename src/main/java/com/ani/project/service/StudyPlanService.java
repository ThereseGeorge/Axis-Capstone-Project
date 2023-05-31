package com.ani.project.service;

import java.util.List;

import com.ani.project.dto.StudyPlanDto;
import com.ani.project.exception.PlanNotFoundException;

public interface StudyPlanService {

    Integer createNewPlan(StudyPlanDto plan);
    List<StudyPlanDto> all();
    Integer deletePlan(Long id) throws PlanNotFoundException;
    StudyPlanDto fetchPlanDetails(Long id) throws PlanNotFoundException;
    Integer updatePlan(StudyPlanDto plan);
}
