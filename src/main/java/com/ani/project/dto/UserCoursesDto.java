package com.ani.project.dto;

import lombok.*;


import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserCoursesDto {
    private long courseId;


    private String courseName;
    private String facultyName;


    private LocalDate startDate;



    private LocalDate endDate;

    private String material;

    private String recording;

}
