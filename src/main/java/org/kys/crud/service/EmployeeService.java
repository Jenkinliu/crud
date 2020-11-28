package org.kys.crud.service;

import org.kys.crud.entity.Employee;
import org.kys.crud.repository.EmployeeRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuyunkun
 * @date 2020/11/28
 */
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee saveOrUpdate(Employee employee) {
        return employeeRepository.saveAndFlush(employee);
    }

    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public Employee getOne(Integer id) {
        return employeeRepository.getOne(id);
    }
}
