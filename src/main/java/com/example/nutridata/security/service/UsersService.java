package com.example.nutridata.security.service;

import com.example.nutridata.security.model.Users;

import java.util.Optional;

public interface UsersService {
    Optional<Users> findByEmail(String email);
}
