package com.ani.project.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.URL;

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
public class ScheduleDto {
    
    private long id;

    @NotEmpty(message="Course name cannot be empty")
    @NotNull(message="Course name cannot be null")
    @NotBlank(message="Course name cannot be blank")
    private String courseName;

    // @FutureOrPresent(message = "Date should not be a past date")
    @NotNull(message="Date cannot be null")
    private LocalDate date;

    @NotNull(message="Time cannot be null")
    // @Future(message="Time should not be in past or present")
    private LocalTime time;

    @Pattern(regexp = "^https?://\\S+$", message = "Invalid meeting link format")
    @URL(message="Invalid URL")
    private String link;

    @Pattern(regexp = "^https?://\\S+$", message = "Invalid recording link")
    @URL(message="Invalid URL")
    private String recording;

}