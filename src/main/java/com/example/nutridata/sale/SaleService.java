package com.example.nutridata.sale;

import com.example.nutridata.sale.dto.SaleRequest;
import com.example.nutridata.sale.dto.SaleResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SaleService {

    Page<SaleResponse> getSaleAll(Pageable pageable);

    SaleResponse getSaleById(Long id);

    SaleResponse saveSale(SaleRequest saleRequest);

    SaleResponse updateSale(Long id, SaleRequest saleRequest);

    void deleteSale(Long id);

}
