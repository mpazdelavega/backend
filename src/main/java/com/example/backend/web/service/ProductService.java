package com.example.backend.web.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.backend.web.model.Product;
import com.example.backend.web.model.ProductSize;

import io.micrometer.common.lang.NonNull;

public interface ProductService {

    List<Product> findAll();

    Page<Product> findAll(Pageable pageable);

    public Page<Product> findByCategory(String category, Pageable pageable);

    Optional<Product> findById(@NonNull Integer id);

    public Product getProductById(Integer id);

    public List<Product> getProductsByName(String name);

    List<Product> getProductsByCategory(String category);

    Optional<ProductSize> findProductSizeByProductAndSize(Product product, String size);

    public List<Product> findProductsWithStock();

    public Page<Product> findProductsByCategoryAndGenderWithStock(String category, String gender, Pageable pageable);

    public Page<Product> findProductsByBrandWithStock(String brand, Pageable pageable);

    public Page<Product> findProductsByDateAddedWithStock(LocalDate date, Pageable pageable);

}
