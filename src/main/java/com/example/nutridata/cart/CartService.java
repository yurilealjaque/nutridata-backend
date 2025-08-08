package com.example.nutridata.cart;

import com.example.nutridata.cart.dto.CartRequest;
import com.example.nutridata.cart.dto.CartResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CartService {

    Page<CartResponse> getAllCarts(Pageable pageable);

    CartResponse getCartById(Long id);

    CartResponse saveCart(CartRequest cartRequest);

    CartResponse addProductToCart(Long cartId, Long productId);

    CartResponse updateCartById(Long id, CartRequest cartRequest);

    void deleteCartById(Long id);

}
