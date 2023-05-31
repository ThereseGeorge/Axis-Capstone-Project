package com.ani.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentEnrolledDto {

    @Column(nullable = false)
    private String courseName;

    @Column(nullable = false)
    private String facultyName;
    @Column(nullable = false)
    private String userName;

}