package com.cg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {

    @RequestMapping("/clock-work")
    public ModelAndView getTimeZone(@RequestParam(name = "city", required = false) String city) {
        ModelAndView modelAndView = new ModelAndView("result");
        Date date = new Date();
        // Lấy ra time zone hiện tại
        TimeZone local = TimeZone.getDefault();
        // Lấy ra time zone của 1 thành phố cụ thể
        TimeZone locale = TimeZone.getTimeZone(city);
        // Tính thời gian hiện tại của một thành phố cụ thể
        long locale_time = date.getTime() +
                (locale.getRawOffset() - local.getRawOffset());
        // Cài đặt lại thời gian cho biến date thành thời gian hiện tại của 1 thành phố cụ thể
        date.setTime(locale_time);
        // Chuyển dữ liệu va gửi qua view
        modelAndView.addObject("city", city);
        modelAndView.addObject("date", date);
        return modelAndView;
    }
}
