package com.example.backend.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.backend.web.model.Cart;
import com.example.backend.web.model.Product;
import com.example.backend.web.model.Size;
import com.example.backend.web.model.ProductSize;
import com.example.backend.web.repository.CartRepository;
import com.example.backend.web.repository.ProductRepository;
import com.example.backend.web.repository.ProductSizeRepository;

import io.micrometer.common.lang.NonNull;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final ProductSizeRepository productSizeRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository, ProductRepository productRepository, ProductSizeRepository productSizeRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.productSizeRepository = productSizeRepository;
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
    public void addToCart(Integer productId, String size) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Size sizeEntity = productSizeRepository.findBySizeName(size)
                .orElseThrow(() -> new RuntimeException("Size not found"));

        ProductSize productSize = productSizeRepository.findByProductAndSize(product, sizeEntity)
                .orElseThrow(() -> new RuntimeException("Product size not found"));

        Cart cart = cartRepository.findByProductSize(productSize).orElse(new Cart());
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
        return cartRepository.findByProductSize_Product(product);
    }

    @Override
    public void save(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public Optional<Cart> findByProductSize(ProductSize productSize) {
        return cartRepository.findByProductSize(productSize);
    }

}
