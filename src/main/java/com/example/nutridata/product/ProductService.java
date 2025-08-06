package com.example.nutridata.product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> listarTodos();
    Optional<Product> obtenerPorId(Integer id);
    Product guardar(Product product);
    Product actualizar(Integer id, Product product);
    void eliminar(Integer id);

}
