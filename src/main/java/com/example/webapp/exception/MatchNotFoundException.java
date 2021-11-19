package com.example.webapp.exception;

public class MatchNotFoundException  extends RuntimeException {
    public MatchNotFoundException(String message) {
        super(message);
    }
}
