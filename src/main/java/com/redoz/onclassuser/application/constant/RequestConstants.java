package com.redoz.onclassuser.application.constant;

public class RequestConstants {
    private RequestConstants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String NAME_MANDATORY_MSG = "Name is mandatory";
    public static final String LAST_NAME_MANDATORY_MSG = "Last name is mandatory";
    public static final String DOCUMENT_NUMBER_MANDATORY_MSG = "Document number is mandatory";
    public static final String TELEPHONE_MANDATORY_MSG = "Telephone is mandatory";
    public static final String TELEPHONE_MIN_SIZE_MSG = "Telephone should have at least 10 characters";
    public static final int TELEPHONE_MIN_SIZE = 10;
    public static final String EMAIL_MANDATORY_MSG = "Email is mandatory";
    public static final String EMAIL_VALID_MSG = "Email should be valid";
    public static final String PASSWORD_MANDATORY_MSG = "Password is mandatory";
}