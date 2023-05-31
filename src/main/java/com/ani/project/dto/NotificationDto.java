package com.ani.project.dto;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class NotificationDto {
    
    private long id;


    @NotNull(message="Date cannot be null")
    @FutureOrPresent(message = "Date should not be a past date")
    private LocalDate date;
    
    @NotEmpty(message="Notification cannot be empty")
    @NotNull(message="Notification cannot be null")
    @NotBlank(message="Notification cannot be blank")
    private String notification;
}