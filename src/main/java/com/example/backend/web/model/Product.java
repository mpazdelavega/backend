package com.example.backend.web.model;

import java.time.LocalDate;

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

    @NonNull
    private LocalDate dateAdded;

    @NonNull
    private int rating;

    @NonNull
    private String color;

    @NonNull
    private String status;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_product_type", nullable = false, updatable = false)
    private Product_type productType;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "gender_id", nullable = false, updatable = false)
    private Gender gender;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id", nullable = false, updatable = false)
    private Brand brand;

    public Product() {
    }

    public Product(Integer id, String name, String description, int price, int discount, String photo,
            LocalDate dateAdded, int rating, String color, String status, Product_type productType, Gender gender,
            Brand brand) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.photo = photo;
        this.dateAdded = dateAdded;
        this.rating = rating;
        this.color = color;
        this.status = status;
        this.productType = productType;
        this.gender = gender;
        this.brand = brand;
    }

    

    
}
