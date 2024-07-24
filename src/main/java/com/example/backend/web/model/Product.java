package com.example.backend.web.model;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.CascadeType;
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
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String name;

    @NonNull
    private String description;

    @NonNull
    private int price;

    @NonNull
    private int discount;

    @NonNull
    private String photo;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_product_type", nullable = false, updatable = false)
    private Product_type productType;

    public Product() {
    }

    public Product(Integer id, String name, int quantity, int discount, String photo, String description, Product_type productType) {
        this.id = id;
        this.name = name;
        this.discount = discount;
        this.photo = photo;
        this.price = quantity;
        this.description = description;
        this.productType = productType;
    }

    
}
