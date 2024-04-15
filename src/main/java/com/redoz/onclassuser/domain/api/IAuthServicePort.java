package com.redoz.onclassuser.domain.api;

import com.redoz.onclassuser.domain.model.User;

public interface IAuthServicePort {
    String registerAdmin(User user);

    String login(String email, String password);

    String registerTutor(User user);
}
