package org.kys.crud.repository;

import org.kys.crud.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author liuyunkun
 * @date 2020/11/28
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
