package com.cermeno.jobfinder.service;

import com.cermeno.jobfinder.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    void save(Category category);

    List<Category> findAll();

    Optional<Category> findById(Integer id);
}
