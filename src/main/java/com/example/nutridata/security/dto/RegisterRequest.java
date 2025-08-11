package com.example.nutridata.security.dto;

public record RegisterRequest(
                String name,
                String lastName,
                String email,
                String phoneNumber,
                String password,
                String occupation) {
}