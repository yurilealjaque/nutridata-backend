package com.example.nutridata.cart;
import com.example.nutridata.cart.dto.CartRequest;
import com.example.nutridata.cart.dto.CartResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CartService {
    Page<CartResponse> getAllCart(Pageable pageable);

    CartResponse getCartById(Long id);

    CartResponse saveCart(CartRequest cartRequest);

    CartResponse updateCart(Long id, CartRequest cartRequest);

    void deleteCartById(Long id);
}

