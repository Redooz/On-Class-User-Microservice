package com.redoz.onclassuser.domain.exception;

import com.redoz.onclassuser.domain.constant.ExceptionConstants;

public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException() {
        super(ExceptionConstants.INVALID_PASSWORD_EXCEPTION_MESSAGE);
    }
}
