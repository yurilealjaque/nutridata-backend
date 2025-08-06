package com.example.nutridata.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.nutridata.product.dto.ProductRequest;
import com.example.nutridata.product.dto.ProductResponse;

public interface ProductService {

    Page<ProductResponse> getAllProducts(Pageable pageable);

    ProductResponse getProductById(Long id);

    ProductResponse saveProduct(ProductRequest productRequest);

    ProductResponse updateProduct(Long id, ProductRequest productRequest);

    void deleteProductById(Long id);

}
