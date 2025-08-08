package com.example.nutridata.user.dto;

import java.sql.Timestamp;

public record UserResponse(
        Long id,
        String name,
        String lastName,
        String email,
        String phoneNumber,
        String occupation,
        Boolean active,
        Timestamp createdAt,
        Timestamp updatedAt) {
}
