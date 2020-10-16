package com.ns.user.backend.service;

import com.ns.core.model.UserProfile;
import com.ns.user.backend.entity.Users;

public interface TokenService {
    Boolean isTokenValid(String token);

    String save(Users user, Boolean isLogin);

    void update(UserProfile user);

    UserProfile findByToken(String token);
}
