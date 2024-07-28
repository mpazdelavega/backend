package com.example.backend.web.model;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cart;

    @NonNull
    private Integer quantity = 0;

    @NonNull
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_size_id", nullable = false, updatable = false)
    private ProductSize productSize;

    public Cart(Integer id_cart, Integer quantity, ProductSize productSize) {
        this.id_cart = id_cart;
        this.quantity = quantity;
        this.productSize = productSize;
    }

    public Cart() {
    }

    
}
