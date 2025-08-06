package com.example.nutridata.user;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
   public Page<User> getAllUser(
           @RequestParam(defaultValue = "0") int page,
           @RequestParam(defaultValue = "10") int size,
           @RequestParam(defaultValue = "id") String sortBy){
        return userService.getAllUser(page, size, sortBy);

    }
}
