package com.example.backend.web.service;

import java.util.List;
import java.util.Optional;

import com.example.backend.web.model.Cart;
import com.example.backend.web.model.Product;

import io.micrometer.common.lang.NonNull;

public interface CartService {

    List<Cart> findAll();

    Optional<Cart> findById(@NonNull Integer id);

    void deleteById(Integer id);

    void addToCart(Integer productId);
    
    void clearCart();

    Optional<Cart> findByProduct(Product product);

    void save(Cart cart);

}
