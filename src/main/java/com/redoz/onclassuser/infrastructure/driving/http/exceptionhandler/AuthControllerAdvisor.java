package com.redoz.onclassuser.infrastructure.driving.http.exceptionhandler;

import com.redoz.onclassuser.domain.exception.EmailAlreadyExistsException;
import com.redoz.onclassuser.domain.exception.UserAlreadyExistsException;
import com.redoz.onclassuser.infrastructure.driving.http.constant.AuthConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@RequiredArgsConstructor
public class AuthControllerAdvisor {
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleUserAlreadyExistsException(UserAlreadyExistsException e) {
        ExceptionResponse response = new ExceptionResponse(
                String.format(AuthConstants.USER_ALREADY_EXISTS_EXCEPTION_MESSAGE, e.getMessage()),
                HttpStatus.BAD_REQUEST.toString(),
                LocalDateTime.now()
        );
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleEmailAlreadyExistsException(EmailAlreadyExistsException e) {
        ExceptionResponse response = new ExceptionResponse(
                String.format(AuthConstants.EMAIL_ALREADY_EXISTS_EXCEPTION_MESSAGE, e.getMessage()),
                HttpStatus.BAD_REQUEST.toString(),
                LocalDateTime.now()
        );
        return ResponseEntity.badRequest().body(response);
    }
}
