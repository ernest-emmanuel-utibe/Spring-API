package com.example.springapi.service.impl;

import com.example.springapi.exceptions.UserNotFoundException;
import com.example.springapi.model.User;
import com.example.springapi.repository.UserRepository;
import com.example.springapi.request.UserRequest;
import com.example.springapi.response.UserResponse;
import com.example.springapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User registerUsers(User registerNewUsers) {
        User newUsers = User.builder()
                .firstName(registerNewUsers.getFirstName())
                .lastName(registerNewUsers.getLastName())
                .email(registerNewUsers.getEmail())
                .build();
        return userRepository.save(newUsers);
    }

    @Override
    public Optional<User> findUserById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public UserResponse usersUpdatingTheirProfileById(UserRequest userRequest, Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User could not be updated."));
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());

        User updatedUsersProfile = userRepository.save(user);
        return mapToDto(updatedUsersProfile);
    }

    private UserResponse mapToDto(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setEmail(user.getEmail());
        return userResponse;
    }

}
