package com.example.nutridata.saleDataile.dto;

public record SaleDetailRequest(
        Long id,
        Long saleId,
        Long productId,
        Integer detailQuantity,
        Double unitPrice) {
}
