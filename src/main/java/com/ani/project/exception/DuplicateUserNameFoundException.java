package com.ani.project.exception;

public class DuplicateUserNameFoundException extends RuntimeException {
    public DuplicateUserNameFoundException(String msg) {
        super(msg);
    }
}
