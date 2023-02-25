package org.example.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ExceptionResult {
    public HttpStatus statusCode;

    public ExceptionResult(HttpStatus statusCode, String message, String path, ZonedDateTime dateTime) {
        this.statusCode = statusCode;
        this.message = message;
        this.path = path;
        this.dateTime = dateTime;
    }

    public String message;
    public String path;
    public ZonedDateTime dateTime;
}
