package com.codegym;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class controller {
    @GetMapping("/convert")
    public ModelAndView convert(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("view/index.jsp");
        double moneyConvert = Double.parseDouble(request.getParameter("convert"));
        double result = moneyConvert * 24000;
        modelAndView.addObject("result",result);
        return modelAndView;
    }
}
