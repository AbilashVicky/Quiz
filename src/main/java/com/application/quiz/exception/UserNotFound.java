package com.application.quiz.exception;

public class UserNotFound extends RuntimeException{
    private String message;

    public UserNotFound(String message){
        super();
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
