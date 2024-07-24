package com.example.backend.web.model;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product_type")
public class Product_type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_product_type;

    @NonNull
    private String category;

    public Product_type() {
    }
}
