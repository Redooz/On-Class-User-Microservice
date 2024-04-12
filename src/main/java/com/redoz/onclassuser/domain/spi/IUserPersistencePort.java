package com.redoz.onclassuser.domain.spi;

import com.redoz.onclassuser.domain.model.User;

public interface IUserPersistencePort {
    void saveUser(User user);
}
