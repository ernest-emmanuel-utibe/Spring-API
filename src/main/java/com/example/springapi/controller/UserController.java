package com.example.springapi.controller;

import com.example.springapi.model.User;
import com.example.springapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register-users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.registerAUsers(user), HttpStatus.CREATED);
    }

//    @GetMapping("/get-users-by-id")
//    public Optional<User> getAllRegisteredUsersById(@RequestParam Long userId) {
//        return userService.getUsersById(userId);
//    }

    @GetMapping("/get-users-by-id")
    public User getAllRegisteredUsersById(@RequestParam Long userId){
        Optional<User> user = userService.getUsersById(userId);
        return user.orElseThrow(() -> new RuntimeException("User not found"));
    }
}

