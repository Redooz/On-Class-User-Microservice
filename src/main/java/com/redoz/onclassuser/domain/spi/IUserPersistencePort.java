package com.redoz.onclassuser.domain.spi;

import com.redoz.onclassuser.domain.model.User;

import java.util.Optional;

public interface IUserPersistencePort {
    Optional<User> findUserByDocumentNumber(String document);

    Optional<User> findUserByEmail(String email);

    void saveUser(User user);
}
