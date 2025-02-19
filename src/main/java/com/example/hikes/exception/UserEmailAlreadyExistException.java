package com.example.hikes.exception;

public class UserEmailAlreadyExistException extends RuntimeException{
    public UserEmailAlreadyExistException(){
        super("Email already exist.");
    }

}

