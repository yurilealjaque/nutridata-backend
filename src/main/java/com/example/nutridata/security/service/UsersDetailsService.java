package com.example.nutridata.security.service;

import java.util.Optional;
import com.example.nutridata.security.model.Users;

public interface UsersDetailsService {
    Optional<Users> findByEmail(String email);
}
