package com.example.springapi.service;

import com.example.springapi.model.User;
import com.example.springapi.request.UserRequest;
import com.example.springapi.response.UserResponse;

import java.util.Optional;

public interface UserService {
    User registerUsers(User registerNewUsers);
    Optional<User> findUserById(Long userId);
    UserResponse usersUpdatingTheirProfileById(UserRequest userRequest, Long id);

}
