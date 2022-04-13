package com.cg.repository.impl;

import com.cg.model.Blog;
import com.cg.repository.IBlogRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class BlogRepository implements IBlogRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Blog> findAll() {
        String queryStr = "SELECT b FROM Blog b";
        TypedQuery<Blog> query = entityManager.createQuery(queryStr, Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findById(Long id) {
        String queryStr = "SELECT b FROM Blog b WHERE b.id=:id";
        TypedQuery<Blog> query = entityManager.createQuery(queryStr, Blog.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public boolean save(Blog blog) {
        String queryStr = "CALL save_blog(:new_content,:new_title,new_idcategory)";
        Query query = entityManager.createNativeQuery(queryStr);
        query.setParameter("new_content", blog.getContent());
        query.setParameter("new_title", blog.getTitle());
        query.setParameter("new_idcategory", blog.getCategory().getIdCategory());
        return query.executeUpdate() == 0;
    }

    @Override
    public boolean remove(Long id) {
        String queryStr = "CALL remove_blog(:id)";
        Query query = entityManager.createNativeQuery(queryStr);
        query.setParameter("id", id);
        return query.executeUpdate() == 0;
    }

    @Override
    public boolean update(Long id, Blog blog) {
        String queryStr = "CALL update_blog(:id,:content,:title,:id_category)";
        Query query = entityManager.createNativeQuery(queryStr);
        query.setParameter("id", id);
        query.setParameter("content", blog.getContent());
        query.setParameter("title", blog.getTitle());
        query.setParameter("id_category", blog.getCategory());
        return query.executeUpdate() == 0;
    }
}
