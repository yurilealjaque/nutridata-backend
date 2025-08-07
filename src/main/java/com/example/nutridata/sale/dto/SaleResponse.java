package com.example.nutridata.sale.dto;

import java.sql.Timestamp;

public record SaleResponse(
        Long id,
        Timestamp updatedAt,
        Timestamp createdAt,
        Double total_pay,
        String payment_method,
        String sale_status,
        String sale_number) {

}
