package com.ani.project.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Setter
@Getter
public class LoginDto {
    @NotBlank(message = "User name is mandatory")
    @NotNull(message = "User name should not be null")
    private String userName;
    @NotNull(message = "Password should not be null")
    @NotBlank(message = "Password is mandatory")
    private String password;
}