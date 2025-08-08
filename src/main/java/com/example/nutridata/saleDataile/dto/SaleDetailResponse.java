package com.example.nutridata.saleDataile.dto;

public record SaleDetailResponse(
        Long id,
        Long saleId,
        Long productId,
        Integer detailQuantity,
        Double unitPrice,
        Double totalPrice) {
}
