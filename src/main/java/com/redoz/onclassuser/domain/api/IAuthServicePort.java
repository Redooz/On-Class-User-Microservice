package com.redoz.onclassuser.domain.api;

import com.redoz.onclassuser.domain.model.User;

public interface IAuthServicePort {
    String registerAdmin(User user);
}
