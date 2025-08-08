package com.example.nutridata.saleDataile;

import com.example.nutridata.product.Product;
import com.example.nutridata.product.ProductRepository;
import com.example.nutridata.sale.Sale;
import com.example.nutridata.sale.SaleRepository;
import com.example.nutridata.saleDataile.dto.SaleDetailRequest;
import com.example.nutridata.saleDataile.dto.SaleDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SaleDetailServiceImpl implements SaleDetailService {

    private final SaleDetailRepository saleDetailRepository;
    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;


    @Override
    public SaleDetailResponse createSaleDetail(Long saleId, Long productId, int quantity, BigDecimal unitPrice, BigDecimal totalPrice) {
        Sale sale = saleRepository.findById(saleId)
                .orElseThrow(()-> new RuntimeException("Sale not found with id: " + saleId));

        Product product = productRepository.findById(productId)
                .orElseThrow(()-> new RuntimeException("Product not found with id: " + productId));

        SaleDetail saleDetail = new SaleDetail();
        saleDetail.setSale(sale);
        saleDetail.setProduct(product);
        saleDetail.setDetailQuantity(quantity);
        saleDetail.setUnitPrice(unitPrice.doubleValue());
        saleDetail.setTotalPrice(totalPrice.doubleValue());

        SaleDetail savedSaleDetail = saleDetailRepository.save(saleDetail);
        return mapToResponse(savedSaleDetail);
    }

    @Override
    public List<SaleDetailResponse> getAllSaleDetails() {
        return saleDetailRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public SaleDetailResponse getSaleDetailById(Long id) {
        SaleDetail saleDetail = saleDetailRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Sale detail not found with id: " + id));
        return mapToResponse(saleDetail);
    }

    @Override
    public SaleDetailResponse updateSaleDetail(SaleDetailRequest request) {
        SaleDetail existing = saleDetailRepository.findById(request.saleId())
                .orElseThrow(()-> new RuntimeException("Sale detail not found with id: " + request.saleId()));
        Sale sale = saleRepository.findById(request.saleId())
                .orElseThrow(()-> new RuntimeException("Sale not fount with id " + request.saleId()));
       Product product = productRepository.findById(request.saleId())
               .orElseThrow(()-> new RuntimeException("Product not fount with id: " + request.productId()));

       existing.setSale(sale);
       existing.setProduct(product);
       existing.setDetailQuantity(request.detailQuantity());
       existing.setUnitPrice(request.unitPrice());
       existing.setTotalPrice(request.unitPrice() * request.detailQuantity());

       SaleDetail updatedSaleDetail = saleDetailRepository.save(existing);
       return mapToResponse(updatedSaleDetail);
    }

    @Override
    public void deleteSaleDetailById(Long id) {
        if (!saleDetailRepository.existsById(id)) {
            throw new RuntimeException("Sale detail not found with id: " + id);
        }
        saleDetailRepository.deleteById(id);
    }

    private SaleDetailResponse mapToResponse(SaleDetail saleDetail) {
        return new SaleDetailResponse(
        saleDetail.getId(),
        saleDetail.getSale().getId(),
        saleDetail.getProduct().getId(),
        saleDetail.getDetailQuantity(),
        saleDetail.getUnitPrice(),
        saleDetail.getTotalPrice());
    }
}