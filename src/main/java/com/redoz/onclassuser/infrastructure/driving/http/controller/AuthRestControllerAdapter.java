package com.redoz.onclassuser.infrastructure.driving.http.controller;

import com.redoz.onclassuser.application.dto.request.LoginRequest;
import com.redoz.onclassuser.application.dto.request.RegisterUserRequest;
import com.redoz.onclassuser.application.dto.response.AuthResponse;
import com.redoz.onclassuser.application.handler.AuthHandler;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth/")
@RequiredArgsConstructor
@Tag(name = "Auth", description = "The Auth Endpoint")
public class AuthRestControllerAdapter {
    private final AuthHandler authHandler;

    @PostMapping("register/admin")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Admin registered"),
            @ApiResponse(responseCode = "400", description = "Invalid data"),
    })
    public ResponseEntity<AuthResponse> registerAdmin(@RequestBody @Valid RegisterUserRequest registerUserRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authHandler.registerAdmin(registerUserRequest));
    }

    @PostMapping("login")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User logged in"),
            @ApiResponse(responseCode = "400", description = "Invalid data"),
    })
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid LoginRequest registerUserRequest) {
        return ResponseEntity.ok(authHandler.login(registerUserRequest));
    }

    @PostMapping("register/tutor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Tutor registered"),
            @ApiResponse(responseCode = "400", description = "Invalid data"),
    })
    public ResponseEntity<AuthResponse> registerTutor(@RequestBody @Valid RegisterUserRequest registerUserRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authHandler.registerTutor(registerUserRequest));
    }

    @PostMapping("register/student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Student registered"),
            @ApiResponse(responseCode = "400", description = "Invalid data"),
    })
    public ResponseEntity<AuthResponse> registerStudent(@RequestBody @Valid RegisterUserRequest registerUserRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authHandler.registerStudent(registerUserRequest));
    }
}
