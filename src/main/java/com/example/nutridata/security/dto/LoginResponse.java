package com.example.nutridata.security.dto;

public record LoginResponse(
        String name,
        String email,
        String token,
        String roles
) {}