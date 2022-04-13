package com.cg.controller;

import com.cg.model.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class ControllerPhoneNumber {

    @RequestMapping("/home")
    public ModelAndView showInfo() {
        ModelAndView modelAndView = new ModelAndView("/info");
        modelAndView.addObject("phoneNumber",new PhoneNumber());
        return modelAndView;
    }

Validator validator=new Validator() {

    @Override
    public boolean supports(Class<?> aClass) {
        return PhoneNumber.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        PhoneNumber phoneNumber = (PhoneNumber) o;
        String number = phoneNumber.getNumber();
        ValidationUtils.rejectIfEmpty(errors,"number","number.empty");
        if(number.length() > 11 || number.length() < 9) {
            errors.rejectValue("number","number.length");
        }
        if(!number.startsWith("0")) {
            errors.rejectValue("number","number.starsWith");
        }
        if(!number.matches("(^$|[0-9]*$)")) {
            errors.rejectValue("number","number.matches");
        }
    }
};
    @PostMapping("/save")
    public ModelAndView save(@Valid @ModelAttribute("phoneNumber") PhoneNumber phoneNumber, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        validator.validate(phoneNumber,bindingResult);
        if(bindingResult.hasFieldErrors()){
             modelAndView.setViewName("/info");
        } else {
            modelAndView.addObject("phoneNumber",phoneNumber);
            modelAndView.setViewName("/result");
        }
        return modelAndView;
    }

    @GetMapping("/hello")
    public ModelAndView hello() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/hello");
        return modelAndView;
    }
}
