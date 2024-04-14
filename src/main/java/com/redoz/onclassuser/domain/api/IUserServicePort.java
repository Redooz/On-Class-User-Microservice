package com.redoz.onclassuser.domain.api;

import com.redoz.onclassuser.domain.model.User;

public interface IUserServicePort {
    void saveUser(User user);
}
