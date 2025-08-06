package com.example.nutridata.sale;

import com.example.nutridata.product.Product;
import com.example.nutridata.product.dto.ProductRequest;
import com.example.nutridata.product.dto.ProductResponse;
import com.example.nutridata.sale.dto.SaleRequest;
import com.example.nutridata.sale.dto.SaleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;

    @Override
    public Page<SaleResponse> getSaleAll(Pageable pageable) {
        return saleRepository.findAll(pageable)
                .map(this::mapToResponse);
    }

    @Override
    public SaleResponse getSaleById(Long id) {
        return saleRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("Sale not found with id " + id));
    }
    @Override
    public SaleResponse saveSale(SaleRequest saleRequest) {
        Sale sale = new Sale();

        sale.setCreatedAt(saleRequest.createdAt());
        sale.setTotal_pay(saleRequest.total_pay());
        sale.setPayment_method(saleRequest.payment_method());
        sale.setSale_status(saleRequest.sale_status());

        return mapToResponse(saleRepository.save(sale));
    }
    @Override
    public SaleResponse updateSale(Long id , SaleRequest saleRequest) {
        Sale sale = saleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sale not found with id " + id));

        sale.setCreatedAt(saleRequest.createdAt());
        sale.setTotal_pay(saleRequest.total_pay());
        sale.setPayment_method(saleRequest.payment_method());
        sale.setSale_status(saleRequest.sale_status());

        return mapToResponse(saleRepository.save(sale));
    }
    @Override
    public void deleteSale(Long id) {
        saleRepository.deleteById(id);
    }

    private SaleResponse mapToResponse(Sale sale) {
        return new SaleResponse(
                sale.getId(),
                sale.getCreatedAt(),
                sale.getTotal_pay(),
                sale.getPayment_method(),
                sale.getSale_status(),
                sale.getSale_number());
    }
}