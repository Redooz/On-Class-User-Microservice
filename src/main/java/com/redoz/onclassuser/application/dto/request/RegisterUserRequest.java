package com.redoz.onclassuser.application.dto.request;

import com.redoz.onclassuser.application.constant.RequestConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Getter
public class RegisterUserRequest {
    @NotBlank(message = RequestConstants.NAME_MANDATORY_MSG)
    private final String name;

    @NotBlank(message = RequestConstants.LAST_NAME_MANDATORY_MSG)
    private final String lastName;

    @NotBlank(message = RequestConstants.DOCUMENT_NUMBER_MANDATORY_MSG)
    private final String documentNumber;

    @NotBlank(message = RequestConstants.TELEPHONE_MANDATORY_MSG)
    @Size(min = RequestConstants.TELEPHONE_MIN_SIZE, message = RequestConstants.TELEPHONE_MIN_SIZE_MSG)
    private final String telephone;

    @NotBlank(message = RequestConstants.EMAIL_MANDATORY_MSG)
    @Email(message = RequestConstants.EMAIL_VALID_MSG)
    private final String email;

    @NotBlank(message = RequestConstants.PASSWORD_MANDATORY_MSG)
    private final String password;
}