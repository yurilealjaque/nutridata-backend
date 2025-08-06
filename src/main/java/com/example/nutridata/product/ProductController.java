package com.example.nutridata.product;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> listar(){
        return productService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> obtenerPorId(@PathVariable Integer id) {
        return productService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Product> guardar(@Valid @RequestBody Product product) {
        return ResponseEntity.ok(productService.guardar(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> actualizar(@PathVariable Integer id, @Valid @RequestBody Product product) {
        return ResponseEntity.ok(productService.actualizar(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> eliminar(@PathVariable Integer id) {
        productService.eliminar(id);
        return ResponseEntity.ok().build();
    }
}
