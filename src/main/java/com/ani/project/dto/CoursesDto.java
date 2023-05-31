package com.ani.project.dto;


import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CoursesDto {
    private long courseId;

    @NotEmpty(message = "Username cant be empty")
    @NotNull(message = "Username cant be null")
    @NotBlank(message = "Username cant be blank")
    private String courseName;



    @NotEmpty(message = "Username cant be empty")
    @NotNull(message = "Username cant be null")
    @NotBlank(message = "Username cant be blank")
    private String facultyName;


    private LocalDate startDate;



    private LocalDate endDate;
    @NotBlank(message = "Material link cannot be blank")
    private String material;
    @NotBlank(message = "Material link cannot be blank")
    private String recording;



}