package com.ani.project.service;

import java.util.List;

import com.ani.project.dto.ScheduleDto;
import com.ani.project.exception.ScheduleNotFoundException;


public interface ScheduleService {
    
    Integer createNewSchedule(ScheduleDto course);
    List<ScheduleDto> all();
    Integer deleteSchedule(Long id) throws ScheduleNotFoundException;
    ScheduleDto fetchScheduleDetails(Long id) throws ScheduleNotFoundException;
    Integer updateSchedule(ScheduleDto course);
    
}