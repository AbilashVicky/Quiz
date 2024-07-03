package com.application.quiz.exception;

import java.time.LocalDateTime;

public class ErrorResponse {
    private String message;
    private int statusCode;
    private LocalDateTime timeStamp;

    public ErrorResponse() {}

    public ErrorResponse(String message, int statusCode, LocalDateTime timeStamp) {
        this.message = message;
        this.statusCode = statusCode;
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
