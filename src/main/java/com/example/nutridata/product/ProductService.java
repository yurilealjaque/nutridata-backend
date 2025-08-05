package com.example.nutridata.product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }
    public List<Product> listarProductos(){
        return productRepository.findAll();
    }
}

