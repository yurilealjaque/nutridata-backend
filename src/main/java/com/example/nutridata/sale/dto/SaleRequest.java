package com.example.nutridata.sale.dto;

import java.sql.Timestamp;

public record SaleRequest(
        Timestamp createdAt,
        Double total_pay,
        String payment_method,
        String sale_status) {
}
