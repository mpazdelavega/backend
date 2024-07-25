package com.example.backend.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.backend.web.exception.ResourceNotFoundException;
import com.example.backend.web.model.Product;
import com.example.backend.web.repository.ProductRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository repository;


    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return (List) this.repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Product> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    @Override
    public Page<Product> findByCategory(String category, Pageable pageable) {
        return repository.findByCategory(category, pageable);
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Product getProductById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return repository.findByProductTypeCategory(category);
    }

}
