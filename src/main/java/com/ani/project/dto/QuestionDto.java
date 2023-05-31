package com.ani.project.dto;

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
public class QuestionDto {
    
    private Long id;
    private String studentName;
    private String question;
    //private String answer;
    private AnswerDto answer;

    // Getters and setters
    // ...
}
