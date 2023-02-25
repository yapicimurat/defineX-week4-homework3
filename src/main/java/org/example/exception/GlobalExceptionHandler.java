package org.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({ResponseErrorException.class})
    public ResponseEntity<ExceptionResult> responseErrorExceptionHandler(ResponseErrorException responseErrorException,
                                                                         HttpServletRequest request){
        return ResponseEntity.ok()
                .body(new ExceptionResult(HttpStatus.INTERNAL_SERVER_ERROR, responseErrorException.getMessage(),
                        request.getServletPath(), ZonedDateTime.now()));
    }

    @ExceptionHandler({MissingRequestParameterException.class})
    public ResponseEntity<ExceptionResult> missingRequestParameterExceptionHandler
            (MissingRequestParameterException missingRequestParameterException, HttpServletRequest request){
        return ResponseEntity.ok()
                .body(new ExceptionResult(HttpStatus.BAD_REQUEST, missingRequestParameterException.getMessage(),
                        request.getServletPath(), ZonedDateTime.now()));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
