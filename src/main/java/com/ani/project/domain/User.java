package com.ani.project.domain;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long userId;

    @Column(unique = true, nullable = false)
    @NotNull(message = "userName should not be null")
    @NotBlank(message = "usename is mandatory")
    private String userName;
    @NotNull(message = "Password should not be null")
    @NotBlank(message = "Password is mandatory")
    @Column(nullable = false)
    private String password;
    @NotNull(message = "Role should not be null")
    @NotBlank(message = "Role is mandatory")
    @Column(nullable = false)
    private String role;
    private LocalDate created;

    @ManyToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Courses> courses=new ArrayList<>();

 




}