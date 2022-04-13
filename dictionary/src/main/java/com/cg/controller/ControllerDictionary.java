package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import javax.jws.WebParam;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ControllerDictionary {
    private Map<String, String> dictionary = new HashMap<>();

    public ControllerDictionary() {
        dictionary.put("hello","Xin chào");
        dictionary.put("goodbye","tạm biệt");
        dictionary.put("name","tên");
        dictionary.put("age","tuổi");
        dictionary.put("dictionary","từ điển");
        dictionary.put("computer","máy tính");
    }

    @GetMapping("/dictionary")
    public ModelAndView dictionary( String convert) {

        ModelAndView modelAndView = new ModelAndView("WEB-INF/views/dictionary.jsp");
        return modelAndView;
    }

    @GetMapping("/result")
    public ModelAndView result(@RequestParam String convert) {
        ModelAndView modelAndView = new ModelAndView("WEB-INF/views/result.jsp");
        String result = dictionary.get(convert);
        modelAndView.addObject("result",result);
        return modelAndView;
    }
}
