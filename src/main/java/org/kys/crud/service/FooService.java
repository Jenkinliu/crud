package org.kys.crud.service;

import org.kys.crud.entity.Foo;
import org.kys.crud.repository.FooRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuyunkun
 * @date 2020/11/20
 */
@Service
public class FooService {

    private final FooRepository fooRepository;

    public FooService(FooRepository fooRepository) {
        this.fooRepository = fooRepository;
    }

    public Foo saveOrUpdate(Foo foo) {
        return fooRepository.saveAndFlush(foo);
    }

    public void delete(Integer id) {
        fooRepository.deleteById(id);

    }

    public List<Foo> getAll() {
        return fooRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public Foo getOne(Integer id) {
        return fooRepository.getOne(id);
    }
}
