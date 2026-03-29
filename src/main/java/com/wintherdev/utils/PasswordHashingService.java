package com.wintherdev.utils;

import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PasswordHashingService {

    public String hash(String password) {
        return BcryptUtil.bcryptHash(password);
    }

    public boolean verify(String password, String hash) {
        return BcryptUtil.matches(password, hash);
    }
}
