package com.skvm.user_service.exceptions;

public class InvalidUserDetailsException extends RuntimeException{
    public InvalidUserDetailsException(String message){
        super(message);
    }
}
