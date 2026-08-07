package com.example.authservice.exception;

public class InvalidCredentialException extends RuntimeException {
    public InvalidCredentialException() {
        super("username or password is wrong");
    }
}
