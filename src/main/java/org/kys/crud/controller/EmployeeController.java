package org.kys.crud.controller;

import org.kys.crud.entity.Employee;
import org.kys.crud.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liuyunkun
 * @date 2020/11/28
 */
@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = {"/employees"})
    public String getAllEmployee(Model model) {
        List<Employee> employees = employeeService.getAll();
        model.addAttribute("employees", employees);
        return "employee/list";
    }

    @GetMapping("/employee")
    public String toAdd() {
        return "employee/form";
    }

    @PostMapping("/employee")
    public String add(Employee employee) {
        employeeService.saveOrUpdate(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employee/{id}")
    public String toEdit(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeService.getOne(id);
        model.addAttribute("employee", employee);
        return "employee/form";
    }

    @PutMapping("/employee")
    public String updateEmployee(Employee employee) {
        employeeService.saveOrUpdate(employee);
        return "redirect:/employees";
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeService.delete(id);
        return "redirect:/employees";
    }
}
