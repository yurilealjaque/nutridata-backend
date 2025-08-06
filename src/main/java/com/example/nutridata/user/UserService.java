package com.example.nutridata.user;

import org.springframework.data.domain.Page;

public interface UserService  {
    Page<User> getAllUser(int page, int size, String sortBy);
}
