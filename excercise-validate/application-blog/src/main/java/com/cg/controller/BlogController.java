package com.cg.controller;

import com.cg.model.Blog;
import com.cg.model.Category;
import com.cg.repository.impl.BlogRepository;
import com.cg.service.IBlogService;
import com.cg.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;
    @GetMapping
    private ModelAndView showListBlog() {
        ModelAndView modelAndView = new ModelAndView("/viewBlogs/list_Blog");
        List<Blog> blogList = blogService.findAll();
        modelAndView.addObject("blogs",blogList);

        return modelAndView;
    }

    @GetMapping("/create-blog")
    private ModelAndView showFormCreateBlog() {
        ModelAndView modelAndView = new ModelAndView("/viewBlogs/createForm");
        Blog blog = new Blog();
        List<Category> categories = categoryService.findAll();
        modelAndView.addObject("categories", categories);
        modelAndView.addObject("blog",blog);
        return modelAndView;
    }

    @PostMapping("/save")
    private ModelAndView save(@ModelAttribute("blog") Blog blog) {
        ModelAndView modelAndView = new ModelAndView("/viewBlogs/createForm");
        System.out.println(blog);
        blogService.save(blog);
        modelAndView.addObject("blog",new Blog());
        modelAndView.addObject("message","Create new blog successful");
        return modelAndView;
    }

}
