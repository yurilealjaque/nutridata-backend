package com.example.nutridata.user;

import com.example.nutridata.user.dto.UserRequest;
import com.example.nutridata.user.dto.UserResponse;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    Page<UserResponse> getAllUsers(Pageable pageable);

    UserResponse getUserById(Long id);

    UserResponse saveUser(UserRequest userRequest);

    UserResponse updateUserById(Long id, UserRequest userRequest);

    void deleteUserById(Long id);

    Optional<User> findByEmail(String email);

}
