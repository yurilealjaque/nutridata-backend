package com.example.nutridata.product;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.example.nutridata.product.dto.ProductRequest;
import com.example.nutridata.product.dto.ProductResponse;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Page<ProductResponse> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable)
                .map(this::mapToResponse);
    }

    @Override
    public ProductResponse getProductById(Long id) {
        return productRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    @Override
    public ProductResponse saveProduct(ProductRequest productRequest) {
        Product product = new Product();

        product.setName(productRequest.name());
        product.setDescription(productRequest.description());
        product.setPrice(productRequest.price());
        product.setStock(productRequest.stock());

        return mapToResponse(productRepository.save(product));
    }

    @Override
    public ProductResponse updateProduct(Long id, ProductRequest productRequest) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        product.setName(productRequest.name());
        product.setDescription(productRequest.description());
        product.setPrice(productRequest.price());
        product.setStock(productRequest.stock());

        return mapToResponse(productRepository.save(product));
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    private ProductResponse mapToResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock());
    }
}
