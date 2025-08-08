package com.example.nutridata.security.dto;

public record RegisterRequest(
        String name,
        String email,
        String password
) {}