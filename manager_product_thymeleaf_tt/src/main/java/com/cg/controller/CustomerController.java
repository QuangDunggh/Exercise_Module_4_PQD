package com.cg.controller;

import com.cg.model.Customer;
import com.cg.service.CustomerServiceImpl;
import com.cg.service.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private ICustomerService customerService = new CustomerServiceImpl();

    @GetMapping
    private ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("/index");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers",customers);
        return modelAndView;
    }

    @GetMapping("/create")
    private ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("customer",new Customer());
        return modelAndView;
    }

    @PostMapping("/save")
    private ModelAndView save(Customer customer, RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView("redirect:/customer");
        customer.setId((int) (Math.random() * 10000));
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("success","Add customer success!!!");
        return modelAndView;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("customer",customerService.findById(id));
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView update(Customer customer) {
        ModelAndView modelAndView = new ModelAndView("redirect:/customer");
        customerService.update(customer.getId(), customer);
        return modelAndView;
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/delete");
        modelAndView.addObject("customer",customerService.findById(id));
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView delete(Customer customer,RedirectAttributes redirectAttributes){
        ModelAndView modelAndView = new ModelAndView("redirect:/customer");
        customerService.remove(customer.getId());
        return modelAndView;
    }

    @GetMapping("/{id}/view")
    public ModelAndView view(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/view");
        modelAndView.addObject("customer",customerService.findById(id));
        return modelAndView;
    }
}
