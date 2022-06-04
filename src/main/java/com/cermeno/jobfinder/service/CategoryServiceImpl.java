package com.cermeno.jobfinder.service;

import com.cermeno.jobfinder.model.Category;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private List<Category> categories;

    public CategoryServiceImpl() {
        categories = new LinkedList<>();

        Category cat1 = new Category();
        cat1.setId(1);
        cat1.setName("Contabilidad");
        cat1.setDescription("Descripcion de la categoria Contabilidad");

        Category cat2 = new Category();
        cat2.setId(2);
        cat2.setName("Ventas");
        cat2.setDescription("Trabajos relacionados con Ventas");


        Category cat3 = new Category();
        cat3.setId(3);
        cat3.setName("Comunicaciones");
        cat3.setDescription("Trabajos relacionados con Comunicaciones");

        Category cat4 = new Category();
        cat4.setId(4);
        cat4.setName("Arquitectura");
        cat4.setDescription("Trabajos de Arquitectura");

        Category cat5 = new Category();
        cat5.setId(5);
        cat5.setName("Educacion");
        cat5.setDescription("Maestros, tutores, etc");

        Category cat6 = new Category();
        cat6.setId(6);
        cat6.setName("Test");
        cat6.setDescription("Pruebas na mas");

        categories.add(cat1);
        categories.add(cat2);
        categories.add(cat3);
        categories.add(cat4);
        categories.add(cat5);
        categories.add(cat6);
    }

    @Override
    public void save(Category category) {
        categories.add(category);
    }

    @Override
    public List<Category> findAll() {
        return categories;
    }

    @Override
    public Optional<Category> findById(Integer id) {
        for (Category category : categories) {
            if (category.getId().equals(id)) {
                return Optional.of(category);
            }
        }

        return Optional.empty();
    }
}
