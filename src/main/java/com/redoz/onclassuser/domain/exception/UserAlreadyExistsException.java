package com.redoz.onclassuser.domain.exception;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String documentNumber) {
        super(documentNumber);
    }
}
