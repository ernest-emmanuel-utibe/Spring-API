package com.example.springapi.controller;

//import com.example.springapi.model.User;
//import com.example.springapi.service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//import java.util.Optional;

@RestController
//@RequestMapping("api/v1")
//@RequiredArgsConstructor
public class UserController {

//    private final UserService userService;

//    @PostMapping("/register-users")
//    public ResponseEntity<User> createUser(@RequestBody User user) {
//        return new ResponseEntity<>(userService.registerAUsers(user), HttpStatus.CREATED);
//    }

//    @GetMapping("/get-users-by-id")
//    public Optional<User> getAllRegisteredUsersById(@RequestParam Long userId) {
//        return userService.getUsersById(userId);
//    }

    @GetMapping("/user")
    public String getAllRegisteredUsersById(@RequestParam Model model){
//        Optional<User> user = userService.getUsersById(userId);
        model.addAttribute("Hello user, you have successfully deployed to aws ec");
//        return user.orElseThrow(() -> new RuntimeException("User not found"));
        return "index";
    }

    @GetMapping("/api/user/{id}")
    @ResponseBody
    public String displayUserId(@PathVariable("id") String id) {
        return "The user id is " + id;
    }
}

