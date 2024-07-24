package com.example.backend.web.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.web.model.Cart;
import com.example.backend.web.model.Product;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer>{
    
    Optional<Cart> findByProduct(Product product);

    Optional<Cart> findByProductId(Integer productId);

    
    
}
