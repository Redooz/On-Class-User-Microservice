package com.redoz.onclassuser.domain.api.usecase;


import com.redoz.onclassuser.configuration.security.service.JwtService;
import com.redoz.onclassuser.domain.api.IUserServicePort;
import com.redoz.onclassuser.domain.model.Role;
import com.redoz.onclassuser.domain.model.User;
import com.redoz.onclassuser.infrastructure.driven.jpa.mysql.mapper.IUserEntityMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AuthUseCaseTest {

    @Mock
    private IUserServicePort userServicePort;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private JwtService jwtService;
    @Mock
    private IUserEntityMapper userEntityMapper;

    private AuthUseCase authUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        authUseCase = new AuthUseCase(userServicePort, passwordEncoder, jwtService, userEntityMapper);
    }

    @Test
    void shouldRegisterUserAsAdmin() {
        User user = getUser();
        user.setPassword("password");
        String encodedPassword = "encodedPassword";
        String token = "token";

        when(passwordEncoder.encode(user.getPassword())).thenReturn(encodedPassword);
        when(jwtService.generateToken(any())).thenReturn(token);

        String result = authUseCase.registerAdmin(user);

        assertEquals(token, result);
        verify(userServicePort, times(1)).saveUser(user);
        verify(userEntityMapper, times(1)).toEntity(user);
        assertEquals(Role.ADMIN, user.getRole());
        assertEquals(encodedPassword, user.getPassword());
    }

    @Test
    void shouldRegisterUser() {
        User user = getUser();
        user.setPassword("password");
        String encodedPassword = "encodedPassword";
        String token = "token";

        when(passwordEncoder.encode(user.getPassword())).thenReturn(encodedPassword);
        when(jwtService.generateToken(any())).thenReturn(token);

        String result = authUseCase.register(user);

        assertEquals(token, result);
        verify(userServicePort, times(1)).saveUser(user);
        verify(userEntityMapper, times(1)).toEntity(user);
        assertEquals(encodedPassword, user.getPassword());
    }

    User getUser() {
        return new User.Builder()
                .documentNumber("123456789")
                .email("johndoe@email.com")
                .name("John")
                .lastName("Doe")
                .telephone("123456789")
                .role(Role.ADMIN)
                .password("password")
                .build();
    }
}
