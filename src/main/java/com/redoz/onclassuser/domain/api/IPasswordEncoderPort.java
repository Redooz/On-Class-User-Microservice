package com.redoz.onclassuser.domain.api;

public interface IPasswordEncoderPort {
    String encode(CharSequence rawPassword);

    boolean matches(CharSequence rawPassword, String encodedPassword);
}
