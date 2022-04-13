package com.cg.controller;

import com.cg.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customers")
public class ControllerCustomer {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/hello")
    public ModelAndView sayHello() {
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }
}
