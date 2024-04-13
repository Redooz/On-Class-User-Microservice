package com.redoz.onclassuser.domain.api.usecase;

import com.redoz.onclassuser.configuration.security.service.JwtService;
import com.redoz.onclassuser.domain.api.IAuthServicePort;
import com.redoz.onclassuser.domain.api.IPasswordEncoderPort;
import com.redoz.onclassuser.domain.api.IUserServicePort;
import com.redoz.onclassuser.domain.model.Role;
import com.redoz.onclassuser.domain.model.User;
import com.redoz.onclassuser.infrastructure.driven.jpa.mysql.mapper.IUserEntityMapper;

public class AuthUseCase implements IAuthServicePort {
    private final IUserServicePort userServicePort;
    private final IPasswordEncoderPort passwordEncoder;
    private final JwtService jwtService;
    private final IUserEntityMapper userEntityMapper;

    public AuthUseCase(IUserServicePort userServicePort, IPasswordEncoderPort passwordEncoder, JwtService jwtService, IUserEntityMapper userEntityMapper) {
        this.userServicePort = userServicePort;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public String registerAdmin(User user) {
        user.setRole(Role.ADMIN);

        return register(user);
    }

    private String register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userServicePort.saveUser(user);

        return jwtService.generateToken(userEntityMapper.toEntity(user));
    }
}
