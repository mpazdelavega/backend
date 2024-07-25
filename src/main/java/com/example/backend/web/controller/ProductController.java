package com.example.backend.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.web.model.Product;
import com.example.backend.web.service.ProductService;

@CrossOrigin(origins={"http://localhost:4200"})
@RequestMapping("api/products")
@RestController
public class ProductController {

    @Autowired
    private ProductService service;
    

    // @GetMapping
    // public Iterable<Product> list(){
    //     return service.findAll();
    // }

    @GetMapping("/page/{page}")
    public Page<Product> listPageable(@PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page, 8);
        return service.findAll(pageable);
    }

    @GetMapping("/filter2")
    public Page<Product> listPageable(@RequestParam(required = false) String category, @RequestParam(defaultValue = "0") Integer page) {
        Pageable pageable = PageRequest.of(page, 8);
        if (category != null && !category.isEmpty()) {
            return service.findByCategory(category, pageable);
        } else {
            return service.findAll(pageable);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        Product product = service.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping
    public List<Product> getProducts(@RequestParam(required = false) String name) {
        if (name != null) {
            return service.getProductsByName(name);
        }
        return service.findAll();
    }

    @GetMapping("/filter")
    public List<Product> getProductsByCategory(@RequestParam String category) {
        return service.getProductsByCategory(category);
    }
}
