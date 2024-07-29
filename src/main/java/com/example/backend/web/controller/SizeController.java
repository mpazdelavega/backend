package com.example.backend.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.web.model.Size;
import com.example.backend.web.service.SizeService;
import org.springframework.web.bind.annotation.GetMapping;


@CrossOrigin(origins={"http://localhost:4200"})
@RequestMapping("api/size")
@RestController
public class SizeController {

    @Autowired
    private SizeService service;

    @GetMapping
    public List<Size> getSizes() {
        return service.findAll();
    }
    
}
