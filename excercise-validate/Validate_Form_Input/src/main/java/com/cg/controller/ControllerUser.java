package com.cg.controller;

import com.cg.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ControllerUser {

    @GetMapping("/")
    public ModelAndView save() {
        ModelAndView modelAndView = new ModelAndView("/info");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {
        ModelAndView modelAttribute = new ModelAndView();
        if(bindingResult.hasFieldErrors()){
            modelAttribute.setViewName("/info");
        } else {
            modelAttribute.setViewName("/result");
        }
        return modelAttribute;
    }
}
