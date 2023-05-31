package com.ani.project.util;

import org.springframework.stereotype.Component;

import com.ani.project.domain.Answer;
import com.ani.project.domain.Question;
import com.ani.project.dto.AnswerDto;
import com.ani.project.dto.QuestionDto;

@Component
public class QuestionMapper {
    public QuestionDto toQuestionDTO(Question question) {
        QuestionDto questionDTO = new QuestionDto();
        questionDTO.setId(question.getId());
        questionDTO.setStudentName(question.getStudentName());
        questionDTO.setQuestion(question.getQuestion());

        if (question.getAnswer() != null) {
            AnswerDto answerDTO = new AnswerDto();
            //answerDTO.setId(question.getAnswer().getId());
            answerDTO.setAnswer(question.getAnswer().getAnswer());
            questionDTO.setAnswer(answerDTO);
        }

        return questionDTO;
    }

    public Question toQuestionEntity(QuestionDto questionDTO) {
        Question question = new Question();
        question.setId(questionDTO.getId());
        question.setStudentName(questionDTO.getStudentName());
        question.setQuestion(questionDTO.getQuestion());

        if (questionDTO.getAnswer() != null) {
            Answer answer = new Answer();
            //answer.setId(questionDTO.getAnswer().getId());
            answer.setAnswer(questionDTO.getAnswer().getAnswer());
            question.setAnswer(answer);
        }

        return question;
    }

    public AnswerDto toAnswerDTO(Answer answer) {
        AnswerDto answerDTO = new AnswerDto();
        //answerDTO.setId(answer.getId());
        answerDTO.setAnswer(answer.getAnswer());
        return answerDTO;
    }

    public Answer toAnswerEntity(AnswerDto answerDTO) {
        Answer answer = new Answer();
        //answer.setId(answerDTO.getId());
        answer.setAnswer(answerDTO.getAnswer());
        return answer;
    }
}

