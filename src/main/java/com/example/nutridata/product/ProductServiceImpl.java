package com.example.nutridata.product;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;


    @Override
    public List<Product> listarTodos() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> obtenerPorId(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Product guardar(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product actualizar(Integer id, Product product) {
        product.setId_producto(id);
        return productRepository.save(product);
    }

    @Override
    public void eliminar(Integer id) {
        productRepository.deleteById(id);
    }
}


