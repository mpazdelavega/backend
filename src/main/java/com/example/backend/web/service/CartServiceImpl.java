package com.example.backend.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.backend.web.model.Cart;
import com.example.backend.web.model.Product;
import com.example.backend.web.repository.CartRepository;
import com.example.backend.web.repository.ProductRepository;

import io.micrometer.common.lang.NonNull;

@Service
public class CartServiceImpl implements CartService {

    private CartRepository cartRepository;

    private ProductRepository productRepository;

    public CartServiceImpl(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    @Override
    public List<Cart> findAll() {
        return (List) this.cartRepository.findAll();

    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Cart> findById(@NonNull Integer id) {
        return cartRepository.findById(id);
    }

    @Override
    public void addToCart(Integer productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        Cart cart = cartRepository.findByProductId(productId).orElse(new Cart());
        cart.setQuantity(cart.getQuantity() + 1);
        cartRepository.save(cart);
    }

    @Transactional
    @Override
    public void deleteById(Integer productId) {
        cartRepository.deleteById(productId);
    }

    @Override
    public void clearCart() {
        cartRepository.deleteAll();
    }

    @Override
    public Optional<Cart> findByProduct(Product product) {
        return cartRepository.findByProduct(product);
    }

    @Override
    public void save(Cart cart) {
        cartRepository.save(cart);
    }

}
