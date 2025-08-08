package com.example.nutridata.cart;

import com.example.nutridata.cart.dto.CartRequest;
import com.example.nutridata.cart.dto.CartResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;

    @Override
    public Page<CartResponse> getAllCarts(Pageable pageable) {
        return cartRepository.findAll(pageable)
                .map(this::mapToResponse);
    }

    @Override
    public CartResponse getCartById(Long id) {
        return cartRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("cart not found with id: " + id));
    }

    @Override
    public CartResponse saveCart(CartRequest cartRequest) {
        Cart cart = new Cart();

        cart.setProductQuantity(cartRequest.productQuantity());

        return mapToResponse(cartRepository.save(cart));
    }

    @Override
    public CartResponse updateCartById(Long id, CartRequest cartRequest) {
        Cart cart = cartRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("cart not found with id: " + id));

        cart.setProductQuantity(cartRequest.productQuantity());

        return mapToResponse(cartRepository.save(cart));
    }

    @Override
    public void deleteCartById(Long id) {
        cartRepository.deleteById(id);
    }

    private CartResponse mapToResponse(Cart cart) {
        return new CartResponse(
                cart.getId(),
                cart.getProductQuantity(),
                cart.getCreatedAt(),
                cart.getUpdatedAt());

    }
}