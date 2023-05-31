package com.ani.project.service;

import java.util.List;

import com.ani.project.dto.MarkDto;
import com.ani.project.exception.MarkNotFoundException;

public interface MarkService {
    
    Integer createNewMark(MarkDto mark);
    List<MarkDto> all();
    Integer deleteMark(Long id) throws MarkNotFoundException;
    MarkDto fetchMarkDetails(Long id) throws MarkNotFoundException;
    Integer updateMark(MarkDto mark);
}
