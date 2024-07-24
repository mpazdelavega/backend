package com.example.backend.web.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.example.backend.web.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

    Page<Product> findAll(Pageable pageable);
    List<Product> findByName(String name);
    List<Product> findByProductTypeCategory(String category);
    
}
