package com.auth.service;

import com.auth.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
