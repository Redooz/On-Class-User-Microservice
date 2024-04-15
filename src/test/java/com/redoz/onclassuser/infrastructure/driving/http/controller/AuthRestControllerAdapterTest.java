package com.redoz.onclassuser.infrastructure.driving.http.controller;

import com.redoz.onclassuser.application.dto.request.LoginRequest;
import com.redoz.onclassuser.application.dto.request.RegisterUserRequest;
import com.redoz.onclassuser.application.dto.response.AuthResponse;
import com.redoz.onclassuser.application.handler.AuthHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class AuthRestControllerAdapterTest {

    @Mock
    private AuthHandler authHandler;

    private AuthRestControllerAdapter authRestControllerAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        authRestControllerAdapter = new AuthRestControllerAdapter(authHandler);
    }

    @Test
    void shouldReturnCreatedStatusAndAuthResponseWhenAdminIsRegistered() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest("John", "Doe", "123456789", "123456789", "john@doe.com", "password");
        AuthResponse authResponse = new AuthResponse("token");

        when(authHandler.registerAdmin(registerUserRequest)).thenReturn(authResponse);

        ResponseEntity<AuthResponse> result = authRestControllerAdapter.registerAdmin(registerUserRequest);

        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(authResponse, result.getBody());
    }

    @Test
    void shouldReturnOkStatusAndAuthResponseWhenUserIsLoggedIn() {
        LoginRequest loginRequest = new LoginRequest("john@doe.com", "password");
        AuthResponse authResponse = new AuthResponse("token");

        when(authHandler.login(loginRequest)).thenReturn(authResponse);

        ResponseEntity<AuthResponse> result = authRestControllerAdapter.login(loginRequest);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(authResponse, result.getBody());
    }

    @Test
    void shouldReturnCreatedStatusAndAuthResponseWhenTutorIsRegistered() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest("John", "Doe", "123456789", "123456789", "john@doe.com", "password");
        AuthResponse authResponse = new AuthResponse("token");

        when(authHandler.registerTutor(registerUserRequest)).thenReturn(authResponse);

        ResponseEntity<AuthResponse> result = authRestControllerAdapter.registerTutor(registerUserRequest);

        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(authResponse, result.getBody());
    }
}
