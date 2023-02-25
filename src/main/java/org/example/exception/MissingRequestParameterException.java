package org.example.exception;

public class MissingRequestParameterException extends RuntimeException{

    public MissingRequestParameterException(String message) {
        super(message);
    }
}
