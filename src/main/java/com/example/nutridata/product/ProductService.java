package com.example.nutridata.product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAll();
    Optional<Product> getById(Integer id);
    Product saveProduct(Product product);
    Product updateProduct(Integer id, Product product);
    void deleteById(Integer id);

}
