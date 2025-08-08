package com.example.nutridata.security.dto;

public record LoginRequest(
        String email,
        String password
) {}