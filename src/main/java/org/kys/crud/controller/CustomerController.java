package org.kys.crud.controller;

import org.kys.crud.entity.Customer;
import org.kys.crud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author liuyunkun
 * @date 2020/11/28
 */
@Controller
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public String getAllCustomer(Model model) {
        model.addAttribute("customers", customerService.getAll());
        return "customer/list";
    }

    @GetMapping("/customer")
    public String toAdd() {
        return "customer/form";
    }

    @PostMapping("/customer")
    public String add(Customer customer) {
        customerService.saveOrUpdate(customer);
        return "redirect:/customers";
    }

    @GetMapping("/customer/{id}")
    public String toEdit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("customer", customerService.getOne(id));
        return "/customer/form";
    }

    @PutMapping("/customer")
    public String updateCustomer(Customer customer) {
        customerService.saveOrUpdate(customer);
        return "redirect:/customers";
    }

    @DeleteMapping("/customer/{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        customerService.delete(id);
        return "redirect:/customers";
    }
}
