package org.example.exception;

public class ResponseErrorException extends RuntimeException{

    public ResponseErrorException(String message) {
        super(message);
    }
}
