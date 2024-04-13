package com.redoz.onclassuser.infrastructure.driven.jpa.mysql.adapter;

import com.redoz.onclassuser.domain.model.User;
import com.redoz.onclassuser.domain.spi.IUserPersistencePort;
import com.redoz.onclassuser.infrastructure.driven.jpa.mysql.mapper.IUserEntityMapper;
import com.redoz.onclassuser.infrastructure.driven.jpa.mysql.repository.IUserRepository;

import java.util.Optional;

public class UserPersistenceAdapter implements IUserPersistencePort {
    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;

    public UserPersistenceAdapter(IUserRepository userRepository, IUserEntityMapper userEntityMapper) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public Optional<User> findUserByDocumentNumber(String document) {
        return userRepository.findById(document).map(userEntityMapper::toModel);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email).map(userEntityMapper::toModel);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(userEntityMapper.toEntity(user));
    }
}
