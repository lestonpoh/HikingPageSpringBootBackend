package com.example.hikes.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex){
        return ResponseEntity.internalServerError().body("An unexpected error occurred");
    }

    @ExceptionHandler(UsernameAlreadyExistException.class)
    public ResponseEntity<String> handleUsernameAlreadyExists(UsernameAlreadyExistException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
