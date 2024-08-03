package com.example.backend.web.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.backend.web.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

    List<Product> findByName(String name);

    List<Product> findByProductTypeCategory(String category);

    @Query("SELECT p FROM Product p WHERE EXISTS (SELECT ps FROM ProductSize ps WHERE ps.product = p AND ps.stock > 0)")
    Page<Product> findAll(Pageable pageable);

    @Query("SELECT p FROM Product p WHERE p.productType.category = :category AND EXISTS (SELECT ps FROM ProductSize ps WHERE ps.product = p AND ps.stock > 0)")
    Page<Product> findByCategory(@Param("category") String category, Pageable pageable);

    @Query("SELECT p FROM Product p WHERE EXISTS (SELECT ps FROM ProductSize ps WHERE ps.product = p AND ps.stock > 0)")
    List<Product> findAllWithStock();

    @Query("SELECT p FROM Product p WHERE p.productType.category = :category AND p.gender.name = :gender AND EXISTS (SELECT ps FROM ProductSize ps WHERE ps.product = p AND ps.stock > 0)")
    Page<Product> findProductsByCategoryAndGenderWithStock(@Param("category") String category, @Param("gender") String gender, Pageable pageable);

    @Query("SELECT p FROM Product p WHERE p.brand.name = :brand AND EXISTS (SELECT ps FROM ProductSize ps WHERE ps.product = p AND ps.stock > 0)")
    Page<Product> findProductsByBrandWithStock(@Param("brand") String brand, Pageable pageable);

    @Query("SELECT p FROM Product p WHERE p.dateAdded >= :date AND EXISTS (SELECT ps FROM ProductSize ps WHERE ps.product = p AND ps.stock > 0)")
    Page<Product> findProductsByDateAddedWithStock(@Param("date") LocalDate date, Pageable pageable);
    
    //@Query("SELECT p FROM Product p WHERE (:gender IS NULL OR p.gender.name IN :genders) AND (:brand IS NULL OR p.brand.name IN :brands) AND EXISTS (SELECT ps FROM ProductSize ps WHERE ps.product = p AND ps.stock > 0)")
    @Query("SELECT p FROM Product p WHERE (:gender IS NULL OR p.gender.name IN :gender) AND (:brand IS NULL OR p.brand.name IN :brand) AND EXISTS (SELECT ps FROM ProductSize ps WHERE ps.product = p AND ps.stock > 0)")
    Page<Product> findProductsByGendersAndBrandsWithStock(@Param("gender") String gender, @Param("brand") String brand, Pageable pageable);
}
