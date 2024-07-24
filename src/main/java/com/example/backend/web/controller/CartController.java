package com.example.backend.web.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.web.model.Cart;
import com.example.backend.web.model.Product;
import com.example.backend.web.service.CartService;
import com.example.backend.web.service.ProductService;

@CrossOrigin(origins={"http://localhost:4200"})
@RequestMapping("api/cart")
@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    
    @GetMapping
    public Iterable<Cart> list(){
        return cartService.findAll();
    }

    @DeleteMapping("/remove/{productId}")
    public void removeFromCart(@PathVariable Integer productId) {
    cartService.deleteById(productId);
  }

    @PostMapping("/add/{productId}")
    public ResponseEntity<Cart> addToCart(@PathVariable Integer productId) {
        Optional<Product> productOpt = productService.findById(productId);
        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            Optional<Cart> cartOpt = cartService.findByProduct(product);
            Cart cart;
            if (cartOpt.isPresent()) {
                cart = cartOpt.get();
                cart.setQuantity(cart.getQuantity() + 1);
            } else {
                cart = new Cart();
                cart.setProduct(product);
                cart.setQuantity(1);
            }
            cartService.save(cart);
            return ResponseEntity.ok(cart);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/clear")
    public void clearCart() {
        cartService.clearCart();
  }

}
