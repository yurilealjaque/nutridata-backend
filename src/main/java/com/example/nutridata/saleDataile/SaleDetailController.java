package com.example.nutridata.saleDataile;

import com.example.nutridata.saleDataile.dto.SaleDetailRequest;
import com.example.nutridata.saleDataile.dto.SaleDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/saleDetail")
@RequiredArgsConstructor
public class SaleDetailController {

    private final SaleDetailService saleDetailService;

    @GetMapping
    public List<SaleDetailResponse> getAllDetails(){
        return saleDetailService.getAllSaleDetails();
    }
    @GetMapping("/{id}")
    public SaleDetailResponse getSaleDetailById(@PathVariable Long id) {
        return saleDetailService.getSaleDetailById(id);
    }
    @PostMapping
    public SaleDetailResponse createSaleDetail(@RequestBody SaleDetailRequest saleDetailRequest) {
        BigDecimal unitPrice = BigDecimal.valueOf(saleDetailRequest.unitPrice());
        BigDecimal totalPrice = unitPrice.multiply(BigDecimal.valueOf(saleDetailRequest.detailQuantity()));

        return saleDetailService.createSaleDetail(
                saleDetailRequest.saleId(),
                saleDetailRequest.productId(),
                saleDetailRequest.detailQuantity(),
                unitPrice,
                totalPrice);
    }
    @PutMapping
    public SaleDetailResponse updateSaleDetail (@RequestBody SaleDetailRequest saleDetailRequest) {
        return  saleDetailService.updateSaleDetail(saleDetailRequest);
    }
    @DeleteMapping("/{id}")
    public void deleteSaleDetail(@PathVariable Long id) {
        saleDetailService.deleteSaleDetailById(id);
    }
}
