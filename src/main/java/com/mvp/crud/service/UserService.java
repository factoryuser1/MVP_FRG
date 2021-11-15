package com.mvp.crud.service;

import com.mvp.crud.model.User;

public interface UserService {
    User getUserByUsername(String username);
}
