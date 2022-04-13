package com.cg.repository;

import com.cg.model.Blog;

import java.util.List;

public interface IGeneralRepository<T> {
    List<T> findAll();
    T findById(Long id);
    boolean save(T t);
    boolean remove(Long id);
    boolean update(Long id, T t);
}
