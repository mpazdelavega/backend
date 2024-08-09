package com.example.backend.web.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.example.backend.web.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{

    Page<User> findAll(Pageable Pageable);

    Optional<User> findByUsername(String username);

}
