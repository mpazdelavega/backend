package com.example.backend.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;

import com.example.backend.web.model.User;
import com.example.backend.web.model.UserRequest;

public interface UserService {
    List<User> findAll();

    Page<User> findAll(Pageable pageable);

    Optional<User> findById(@NonNull Integer id);

    User save(User user);

    Optional<User> update(UserRequest user, Integer id);

    void deleteById(Integer id);
}
