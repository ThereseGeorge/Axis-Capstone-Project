package com.ani.project.exception;

public class QuestionNotFoundException extends RuntimeException{

    public QuestionNotFoundException(String msg){
        super(msg);
    }
}
