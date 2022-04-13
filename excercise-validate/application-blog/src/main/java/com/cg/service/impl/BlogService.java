package com.cg.service.impl;

import com.cg.model.Blog;
import com.cg.repository.IBlogRepository;
import com.cg.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public boolean save(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public boolean update(Long id, Blog blog) {
        return blogRepository.update(id,blog);
    }

    @Override
    public boolean remove(Long id) {
        return blogRepository.remove(id);
    }
}
