package com.redoz.onclassuser.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RegisterUserRequest {
    private final String name;
    private final String lastName;
    private final String documentNumber;
    private final String telephone;
    private final String email;
    private final String password;
}
