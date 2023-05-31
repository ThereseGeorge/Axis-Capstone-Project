package com.ani.project.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Courses {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long courseId;

    @Column(nullable = false)
    private String courseName;

    @Column(nullable = false)
    private String facultyName;

    private LocalDate startDate;
    private LocalDate endDate;


    private String material;

    private String recording;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_courses",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users = new ArrayList<>();





}