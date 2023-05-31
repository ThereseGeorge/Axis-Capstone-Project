package com.ani.project.repository;



import com.ani.project.domain.Courses;
import com.ani.project.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoursesRepository extends JpaRepository<Courses,Long> {
    List<Courses> findAllByCourseName(String courseName);



}