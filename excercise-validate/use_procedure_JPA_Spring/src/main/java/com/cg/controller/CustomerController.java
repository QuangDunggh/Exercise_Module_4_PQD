package com.cg.controller;

import com.cg.model.Customer;
import com.cg.service.IServiceCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
    @Autowired
    private IServiceCustomer serviceCustomer;

    @GetMapping("/save")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }
    @PostMapping("/save")
    public  ModelAndView createCustomer(@ModelAttribute("customer") Customer customer) {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("customer",customer);
        serviceCustomer.insertWithStoreProcedure(customer);
        modelAndView.addObject("message","New customer created successfully");
        return modelAndView;
    }
}
