package com.example.nutridata.cart.dto;

import java.sql.Timestamp;

public record CartResponse(

        Long id,
        Integer productQuantity,
        Timestamp createdAt,
        Timestamp updatedAt) {
}
