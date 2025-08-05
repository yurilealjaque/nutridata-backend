package com.example.nutridata.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService= userService;
    }
    @GetMapping("/user")
    public List<User> getUser(){
        return userService.userList();

    }
}
