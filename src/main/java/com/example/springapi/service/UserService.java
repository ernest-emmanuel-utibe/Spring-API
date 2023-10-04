package com.example.springapi.service;

import com.example.springapi.model.User;

import java.util.Optional;

public interface UserService {
    User registerAUsers(User registerNewUsers);
    Optional<User> getUsersById(Long getUsersById);

}
