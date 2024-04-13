package com.redoz.onclassuser.domain.exception;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(String email) {
        super(email);
    }
}
