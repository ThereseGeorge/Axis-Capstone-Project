package com.ani.project.dto;

import java.time.LocalDate;

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
public class StudyPlanDto {
    
    private long id;

    @NotNull(message="Start Date cannot be null")
    private LocalDate startDate;
    
    @NotNull(message="Target Date cannot be null")
    private LocalDate targetDate;
    
    @NotEmpty(message="Plan cannot be empty")
    @NotNull(message="Plan cannot be null")
    @NotBlank(message="Plan cannot be blank")
    private String plan;
    
    private String progress;
    
}
