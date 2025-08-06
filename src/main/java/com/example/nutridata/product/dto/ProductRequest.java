package com.example.nutridata.product.dto;

public record ProductRequest(
    String name,
    String description,
    Double price,
    int stock) {
}