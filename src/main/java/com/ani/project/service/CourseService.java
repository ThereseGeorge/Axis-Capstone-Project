package com.ani.project.service;

import com.ani.project.dto.CoursesDto;
import com.ani.project.exception.CourseNotFoundException;
import com.ani.project.exception.UserNotFoundException;

import java.util.List;

public interface CourseService {



    Integer createNewCourse(CoursesDto dto);

    List<CoursesDto> all();

    Integer deleteCourse(Long courseId) throws UserNotFoundException;

    Integer updateCourse(CoursesDto dto,Long courseId);

    CoursesDto fetchCourseDetails(Long id) throws UserNotFoundException;
    List<CoursesDto> getCoursesByCourseName(String courseName) throws CourseNotFoundException;


}
