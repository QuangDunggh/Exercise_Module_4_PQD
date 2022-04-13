package com.cg.service.impl;

import com.cg.model.Category;
import com.cg.repository.ICategoryRepository;
import com.cg.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return null;
    }

    @Override
    public boolean save(Category category) {
        return false;
    }

    @Override
    public boolean update(Long id, Category category) {
        return false;
    }

    @Override
    public boolean remove(Long id) {
        return false;
    }
}
