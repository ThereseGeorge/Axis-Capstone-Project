package com.ani.project.exception;

public class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException(String msg)
    {
        super("course not found");
    }
}
