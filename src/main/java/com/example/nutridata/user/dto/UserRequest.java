package com.example.nutridata.user.dto;

public record UserRequest(
                String name,
                String lastName,
                String email,
                String phoneNumber,
                String password,
                String occupation) {
}
