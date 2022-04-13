package com.cg.service;

import java.util.List;

public interface IGeneralService<T> {
    List<T> findAll();
    T findById (Long id);
    boolean save (T t);
    boolean update(Long id, T t);
    boolean remove(Long id);
}
