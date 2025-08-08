package com.example.nutridata.cart.dto;

import com.example.nutridata.product.Product;

import java.sql.Timestamp;
import java.util.List;

public record CartResponse(
                Long id,
                Integer productQuantity,
                List<Product> products,
                Timestamp createdAt,
                Timestamp updatedAt) {
}
