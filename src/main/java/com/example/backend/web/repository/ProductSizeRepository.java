package com.example.backend.web.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.web.model.Product;
import com.example.backend.web.model.ProductSize;
import com.example.backend.web.model.Size;

@Repository
public interface ProductSizeRepository extends CrudRepository<ProductSize, Integer>{
    Optional<ProductSize> findByProductAndSize(Product product, Size size);
    Optional<Size> findBySizeName(String sizeName);
}
