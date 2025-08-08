package com.example.nutridata.cart.dto;

import com.example.nutridata.product.Product;
import com.example.nutridata.sale.Sale;

import java.sql.Timestamp;

public record CartResponse(

                Long id,
                Integer productQuantity,
                Timestamp createdAt,
                Timestamp updatedAt) {
}
