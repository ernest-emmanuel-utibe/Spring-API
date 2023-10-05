//package com.example.springapi.service.impl;
//
//import com.example.springapi.model.User;
//import com.example.springapi.model.UserRepository;
//import com.example.springapi.service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class UserServiceImpl implements UserService {
//
//    private final UserRepository userRepository;
//
//    @Override
//    public User registerAUsers(User registerNewUsers) {
//        User newUsers = User.builder()
//                .firstName(registerNewUsers.getFirstName())
//                .lastName(registerNewUsers.getLastName())
//                .email(registerNewUsers.getEmail())
//                .build();
//        return userRepository.save(newUsers);
//    }
//
//    @Override
//    public Optional<User> getUsersById(Long getUsersId) {
//        return userRepository.findById(getUsersId);
//    }
//}
