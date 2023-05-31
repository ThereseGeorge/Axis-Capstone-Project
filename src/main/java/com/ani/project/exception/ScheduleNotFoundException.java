package com.ani.project.exception;

public class ScheduleNotFoundException extends RuntimeException{
    
    public ScheduleNotFoundException(String msg){
        super(msg);
    }
}