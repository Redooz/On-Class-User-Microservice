package com.redoz.onclassuser.infrastructure.driving.http.constant;

public class AuthConstants {
    private AuthConstants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String USER_ALREADY_EXISTS_EXCEPTION_MESSAGE = "User with document number %s already exists";
    public static final String EMAIL_ALREADY_EXISTS_EXCEPTION_MESSAGE = "User with email %s already exists";
}
