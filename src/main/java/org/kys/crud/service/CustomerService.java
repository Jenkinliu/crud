package org.kys.crud.service;

import org.kys.crud.entity.Customer;
import org.kys.crud.repository.CustomerRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuyunkun
 * @date 2020/11/28
 */
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer saveOrUpdate(Customer foo) {
        return customerRepository.saveAndFlush(foo);
    }

    public void delete(Integer id) {
        customerRepository.deleteById(id);

    }

    public List<Customer> getAll() {
        return customerRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public Customer getOne(Integer id) {
        return customerRepository.getOne(id);
    }



}
