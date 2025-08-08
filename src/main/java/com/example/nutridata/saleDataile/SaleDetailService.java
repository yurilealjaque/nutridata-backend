package com.example.nutridata.saleDataile;

import com.example.nutridata.saleDataile.dto.SaleDetailRequest;
import com.example.nutridata.saleDataile.dto.SaleDetailResponse;

import java.math.BigDecimal;
import java.util.List;

public interface SaleDetailService {

    SaleDetailResponse createSaleDetail(Long saleId, Long productId, int quantity, BigDecimal unitPrice,BigDecimal totalPrice);
    List<SaleDetailResponse> getAllSaleDetails();
    SaleDetailResponse getSaleDetailById(Long id);
    SaleDetailResponse updateSaleDetail(SaleDetailRequest saleDetailRequest);
    void deleteSaleDetailById(Long id);
}
