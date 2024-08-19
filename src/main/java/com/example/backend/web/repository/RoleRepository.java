package com.example.backend.web.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.backend.web.model.Role;

public interface RoleRepository extends CrudRepository<Role, Integer>{

    Optional<Role> findByName(String name);

}

