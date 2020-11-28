package org.kys.crud.repository;

import org.kys.crud.entity.Foo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author liuyunkun
 * @date 2020/11/20
 */
@Repository
public interface FooRepository extends JpaRepository<Foo, Integer> {
}
