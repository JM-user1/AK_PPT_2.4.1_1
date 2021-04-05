package com.jm.crud.service;

import com.jm.crud.entity.User;

import java.util.List;

public interface UserService {
    User findUserById(Long userId);
    boolean saveUser(User user);
    boolean deleteUser(Long userId);
    List<User> allUsers();
    User getById(Long id);
}
