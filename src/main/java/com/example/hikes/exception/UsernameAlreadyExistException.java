package com.example.hikes.exception;

public class UsernameAlreadyExistException extends RuntimeException{
    public UsernameAlreadyExistException(){
        super("Username already exist.");
    }
}

