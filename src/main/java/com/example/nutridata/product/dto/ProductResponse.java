package com.example.nutridata.product.dto;

public record ProductResponse(
    Long id,
    String name,
    String description,
    Double price,
    int stock) {
}