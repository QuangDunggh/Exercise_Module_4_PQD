package com.cg.controller;

import com.cg.model.Employee;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("employee/")
public class controllerEmployee {

    @GetMapping("showForm")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @PostMapping("addEmployee")
    public ModelAndView submit(@ModelAttribute("employee") Employee employee) {
        ModelAndView modelAndView = new ModelAndView("/info");
        modelAndView.addObject("name", employee.getName());
        modelAndView.addObject("contactNumber", employee.getContactNumber());
        modelAndView.addObject("id",employee.getId());
        return modelAndView;
    }
}
