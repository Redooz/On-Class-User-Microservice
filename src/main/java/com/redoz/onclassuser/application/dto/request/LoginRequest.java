package com.redoz.onclassuser.application.dto.request;

import com.redoz.onclassuser.application.constant.RequestConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Getter
public class LoginRequest {
    @NotBlank(message = RequestConstants.EMAIL_MANDATORY_MSG)
    @Email(message = RequestConstants.EMAIL_VALID_MSG)
    private final String email;

    @NotBlank(message = RequestConstants.PASSWORD_MANDATORY_MSG)
    private final String password;
}
