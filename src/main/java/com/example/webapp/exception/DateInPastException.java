package com.example.webapp.exception;

public class DateInPastException extends RuntimeException{

    public DateInPastException(String message){
        super(message);
    }
}
