package com.cg.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategory;
    private String category;
    @OneToMany (mappedBy = "category", targetEntity = Blog.class)
    private List<Blog> blogs;

    public Category() {
    }
    public Category(String category) {
        this.category = category;
    }
    public Category(Long idCategory, String category, List<Blog> blogs) {
        this.idCategory = idCategory;
        this.category = category;
        this.blogs = blogs;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    @Override
    public String toString() {
        return "Category{" +
                "idCategory=" + idCategory +
                ", category='" + category + '\'' +
                ", blogs=" + blogs +
                '}';
    }
}
