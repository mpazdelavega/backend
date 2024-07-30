package com.example.backend.web.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.backend.web.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

    @Query("SELECT p FROM Product p WHERE EXISTS (SELECT ps FROM ProductSize ps WHERE ps.product = p AND ps.stock > 0)")
    Page<Product> findAll(Pageable pageable);
    List<Product> findByName(String name);
    List<Product> findByProductTypeCategory(String category);
    @Query("SELECT p FROM Product p WHERE p.productType.category = :category AND EXISTS (SELECT ps FROM ProductSize ps WHERE ps.product = p AND ps.stock > 0)")
    Page<Product> findByCategory(@Param("category") String category, Pageable pageable);
    @Query("SELECT p FROM Product p WHERE EXISTS (SELECT ps FROM ProductSize ps WHERE ps.product = p AND ps.stock > 0)")
    List<Product> findAllWithStock();
    
}
