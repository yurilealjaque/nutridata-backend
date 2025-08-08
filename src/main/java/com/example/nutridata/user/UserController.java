package com.example.nutridata.user;

import com.example.nutridata.user.dto.UserRequest;
import com.example.nutridata.user.dto.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<Page<UserResponse>> getAllUser(Pageable pageable) {
        Page<UserResponse> users = userService.getAllUsers(pageable);

        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            UserResponse foundUser = userService.getUserById(id);

            return ResponseEntity.ok(foundUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with id: " + id);
        }
    }

    @PostMapping
    public ResponseEntity<UserResponse> saveUser(@Valid @RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService.saveUser(userRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUserById(
            @PathVariable Long id,
            @Valid @RequestBody UserRequest userRequest) {
        try {
            UserResponse updatedUser = userService.updateUserById(id, userRequest);

            return ResponseEntity.ok(updatedUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with id: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);

        return ResponseEntity.noContent().build();
    }

}
