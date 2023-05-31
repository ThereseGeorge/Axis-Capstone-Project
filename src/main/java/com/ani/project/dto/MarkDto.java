package com.ani.project.dto;

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
public class MarkDto {
    
    private long id;

    @NotEmpty(message="Name cannot be empty")
    @NotNull(message="Name cannot be null")
    @NotBlank(message="Name cannot be blank")
    private String name;
    

    // @NotEmpty(message="Marks cannot be empty")
    // @NotNull(message="Marks cannot be null")
    // @NotBlank(message="Marks cannot be blank")
    private long marks;

    @NotEmpty(message="Grade cannot be empty")
    @NotNull(message="Grade cannot be null")
    @NotBlank(message="Grade cannot be blank")
    private String grade;

    
    private String feedback;
}