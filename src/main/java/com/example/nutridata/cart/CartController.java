package com.example.nutridata.cart;

import com.example.nutridata.cart.dto.CartRequest;
import com.example.nutridata.cart.dto.CartResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping
    public ResponseEntity<Page<CartResponse>> getAllCarts(Pageable pageable) {
        Page<CartResponse> carts = cartService.getAllCarts(pageable);

        return ResponseEntity.ok(carts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            CartResponse foundCart = cartService.getCartById(id);

            return ResponseEntity.status(HttpStatus.OK).body(foundCart);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cart not found with id: " + id);
        }
    }

    @PostMapping
    public ResponseEntity<CartResponse> saveCart(@Valid @RequestBody CartRequest cartRequest) {
        return ResponseEntity.ok(cartService.saveCart(cartRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCart(
            @PathVariable Long id,
            @Valid @RequestBody CartRequest cartRequest) {
        try {
            CartResponse updatedCart = cartService.updateCartById(id, cartRequest);

            return ResponseEntity.status(HttpStatus.OK).body(updatedCart);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cart updated failed: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        cartService.deleteCartById(id);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{cartId}/products/{productId}")
    public ResponseEntity<CartResponse> addProductToCart(@PathVariable Long cartId, @PathVariable Long productId) {
        return ResponseEntity.ok(cartService.addProductToCart(cartId, productId));
    }

}
