package com.redoz.onclassuser.configuration;

import com.redoz.onclassuser.configuration.security.service.JwtService;
import com.redoz.onclassuser.domain.api.IAuthServicePort;
import com.redoz.onclassuser.domain.api.IUserServicePort;
import com.redoz.onclassuser.domain.api.usecase.AuthUseCase;
import com.redoz.onclassuser.domain.api.usecase.UserUseCase;
import com.redoz.onclassuser.domain.spi.IUserPersistencePort;
import com.redoz.onclassuser.infrastructure.driven.jpa.mysql.adapter.UserPersistenceAdapter;
import com.redoz.onclassuser.infrastructure.driven.jpa.mysql.mapper.IUserEntityMapper;
import com.redoz.onclassuser.infrastructure.driven.jpa.mysql.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AuthBeanConfiguration {
    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;
    private final ApplicationBeanConfiguration applicationBeanConfig;
    private final JwtService jwtService;

    @Bean
    public IUserPersistencePort userPersistencePort() {
        return new UserPersistenceAdapter(userRepository, userEntityMapper);
    }

    @Bean
    public IUserServicePort userServicePort() {
        return new UserUseCase(userPersistencePort());
    }

    @Bean
    public IAuthServicePort authServicePort() {
        return new AuthUseCase(
                userServicePort(),
                applicationBeanConfig.passwordEncoder(),
                jwtService,
                userEntityMapper
        );
    }
}
