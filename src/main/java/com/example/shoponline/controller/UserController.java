package com.example.shoponline.controller;

import com.example.shoponline.model.NaturalStone;
import com.example.shoponline.model.User;
import com.example.shoponline.repository.UserRepository;
import com.example.shoponline.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return ResponseEntity.ok().body(userService.saveNewUser(user));
    }
    @GetMapping
    public ResponseEntity<List<User>> retrieveUsers(){
        return ResponseEntity.ok().body(userService.retrieveUsers());
    }
}
