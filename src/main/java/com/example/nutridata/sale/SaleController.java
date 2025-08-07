package com.example.nutridata.sale;

import com.example.nutridata.product.dto.ProductRequest;
import com.example.nutridata.product.dto.ProductResponse;
import com.example.nutridata.sale.dto.SaleRequest;
import com.example.nutridata.sale.dto.SaleResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/sale")
@RequiredArgsConstructor
public class SaleController {
    private final SaleService saleService;

    @GetMapping
    public ResponseEntity<Page<SaleResponse>> getAllSale(Pageable pageable) {
        Page<SaleResponse> sale = saleService.getSaleAll(pageable);
        return ResponseEntity.ok(sale);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSaleById(@PathVariable Long id) {
        try {
            SaleResponse foundSale = saleService.getSaleById(id);
            return ResponseEntity.status(HttpStatus.OK).body(foundSale);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sale not found with id " + id);
        }
    }

    @PostMapping
    public ResponseEntity<SaleResponse> saveSale(@Valid @RequestBody SaleRequest saleRequest) {
        return ResponseEntity.ok(saleService.saveSale(saleRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSale(
            @PathVariable Long id,
            @Valid @RequestBody SaleRequest saleRequest) {
        try {
           SaleResponse updateSale = saleService.updateSale(id, saleRequest);

            return ResponseEntity.status(HttpStatus.OK).body(updateSale);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sale updated failed: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSale(@PathVariable Long id) {
        saleService.deleteSale(id);

        return ResponseEntity.noContent().build();
    }
}
