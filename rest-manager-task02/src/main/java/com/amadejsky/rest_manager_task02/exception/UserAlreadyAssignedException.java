package com.amadejsky.rest_manager_task02.exception;

public class UserAlreadyAssignedException extends RuntimeException{
    public UserAlreadyAssignedException(String message) {
        super(message);
    }
}
