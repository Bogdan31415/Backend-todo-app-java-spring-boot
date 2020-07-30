package com.bohdan.todolist.exceptions;

public class SpringToDoException extends RuntimeException {
    public SpringToDoException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public SpringToDoException(String exMessage) {
        super(exMessage);
    }
}
