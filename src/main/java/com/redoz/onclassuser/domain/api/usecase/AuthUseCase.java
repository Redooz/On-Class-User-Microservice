package com.redoz.onclassuser.domain.api.usecase;

import com.redoz.onclassuser.configuration.security.service.JwtService;
import com.redoz.onclassuser.domain.api.IAuthServicePort;
import com.redoz.onclassuser.domain.api.IUserServicePort;
import com.redoz.onclassuser.domain.exception.InvalidPasswordException;
import com.redoz.onclassuser.domain.model.Role;
import com.redoz.onclassuser.domain.model.User;
import com.redoz.onclassuser.infrastructure.driven.jpa.mysql.mapper.IUserEntityMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthUseCase implements IAuthServicePort {
    private final IUserServicePort userServicePort;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final IUserEntityMapper userEntityMapper;

    public AuthUseCase(IUserServicePort userServicePort, PasswordEncoder passwordEncoder, JwtService jwtService, IUserEntityMapper userEntityMapper) {
        this.userServicePort = userServicePort;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public String login(String email, String password) {
        var user = userServicePort.findUserByEmail(email);
        var isPasswordMatch = passwordEncoder.matches(password, user.getPassword());

        if (!isPasswordMatch) {
            throw new InvalidPasswordException();
        }

        return jwtService.generateToken(userEntityMapper.toEntity(user));
    }

    @Override
    public String registerAdmin(User user) {
        user.setRole(Role.ADMIN);

        return register(user);
    }

    @Override
    public String registerTutor(User user) {
        user.setRole(Role.TUTOR);

        return register(user);
    }

    protected String register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userServicePort.saveUser(user);

        return jwtService.generateToken(userEntityMapper.toEntity(user));
    }

}
