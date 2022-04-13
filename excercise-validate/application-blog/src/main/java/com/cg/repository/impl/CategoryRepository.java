package com.cg.repository.impl;

import com.cg.model.Category;
import com.cg.repository.ICategoryRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class CategoryRepository implements ICategoryRepository {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Category> findAll() {
        String queryStr = "SELECT c FROM Category c";
        TypedQuery<Category> query = entityManager.createQuery(queryStr,Category.class);
        return query.getResultList();
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
    public boolean remove(Long id) {
        return false;
    }

    @Override
    public boolean update(Long id, Category category) {
        return false;
    }
}
