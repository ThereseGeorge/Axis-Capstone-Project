package com.ani.project.service;

import java.util.List;

import com.ani.project.dto.AnswerDto;
import com.ani.project.dto.QuestionDto;

public interface QuestionService {
    QuestionDto createQuestion(QuestionDto questionDTO);
    QuestionDto getQuestion(Long id);
    List<QuestionDto> getAllQuestions();
    AnswerDto createAnswer(Long questionId, AnswerDto answerDTO);
    AnswerDto updateAnswer(Long questionId, AnswerDto answerDTO);
    void deleteAnswer(Long questionId);
    void deleteQuestion(Long id);
}
