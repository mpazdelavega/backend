package com.example.backend.web.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.web.model.Size;

@Repository
public interface SizeRepository extends CrudRepository<Size, Integer>{
    Optional<Size> findByName(String name);
}
