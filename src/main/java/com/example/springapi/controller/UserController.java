package com.example.springapi.controller;

import com.example.springapi.model.User;
import com.example.springapi.request.UserRequest;
import com.example.springapi.response.UserResponse;
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
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        return new ResponseEntity<>(userService.registerUsers(user), HttpStatus.CREATED);
    }

    @GetMapping("/get-users-by-id/{id}")
    public Optional<User> findAllRegisteredUsersById(@PathVariable("id") Long userId)
    {
        Optional<User> user = userService.findUserById(userId);
        return Optional.ofNullable(user.orElseThrow(() -> new RuntimeException("User not found")));
    }

    @PutMapping("users/{id}/update")
    public ResponseEntity<UserResponse> updatePokemon(@RequestBody UserRequest userRequest, @PathVariable("id") Long userId)
    {
        UserResponse response = userService.usersUpdatingTheirProfileById(userRequest, userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get-all-user")
    public ResponseEntity<UserResponse> getAllRegisteredUsers(@RequestMapping UserRequest userRequest,
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize)
    {

    }
}

