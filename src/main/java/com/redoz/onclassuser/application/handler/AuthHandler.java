package com.redoz.onclassuser.application.handler;

import com.redoz.onclassuser.application.dto.request.LoginRequest;
import com.redoz.onclassuser.application.dto.request.RegisterUserRequest;
import com.redoz.onclassuser.application.dto.response.AuthResponse;
import com.redoz.onclassuser.application.mapper.IAuthRequestMapper;
import com.redoz.onclassuser.domain.api.IAuthServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthHandler {
    private final IAuthServicePort authServicePort;
    private final IAuthRequestMapper authRequestMapper;

    public AuthResponse registerAdmin(RegisterUserRequest request) {
        return new AuthResponse(authServicePort.registerAdmin(authRequestMapper.toUserModel(request)));
    }

    public AuthResponse login(LoginRequest request) {
        return new AuthResponse(authServicePort.login(request.getEmail(), request.getPassword()));
    }
    
}
