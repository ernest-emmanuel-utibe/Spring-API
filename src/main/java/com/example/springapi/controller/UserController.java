package com.example.springapi.controller;

import com.example.springapi.model.User;
import com.example.springapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register-users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.registerAUsers(user), HttpStatus.CREATED);
    }

    @GetMapping("/get-users-by-id/{id}")
    public Optional<User> getAllRegisteredUsersById(@PathVariable("id") Long userId) {
        Optional<User> user = userService.findUserById(userId);
        return Optional.ofNullable(user.orElseThrow(() -> new RuntimeException("User not found")));
    }

//    @GetMapping("/user")
//    public Optional<User> getAllRegisteredUsersById(@RequestParam User userId) {
//        Optional<User> user = userService.findUserById(userId);
//        return user.orElseThrow(() -> new RuntimeException("User not found"));
//        return user;
//    }

//    @GetMapping("/api/user/{id}")
//    @ResponseBody
//    public String displayUserId(@PathVariable("id") String id) {
//        return "The user id is " + id;
//    }
}

