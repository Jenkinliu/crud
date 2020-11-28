package org.kys.crud.controller;

import org.kys.crud.entity.Foo;
import org.kys.crud.service.FooService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liuyunkun
 * @date 2020/11/20
 */
@Controller
public class FooController {

    private final FooService fooService;

    public FooController(FooService fooService) {
        this.fooService = fooService;
    }

    @GetMapping(value = {"/", "/foos"})
    public String getAllFoo(Model model) {
        List<Foo> foos = fooService.getAll();
        model.addAttribute("foos", foos);
        return "foo/list";
    }

    @GetMapping("/foo")
    public String toAdd() {
        return "foo/form";
    }

    @PostMapping("/foo")
    public String add(Foo foo) {
        fooService.saveOrUpdate(foo);
        return "redirect:/foos";
    }

    @GetMapping("/foo/{id}")
    public String toEdit(@PathVariable("id") Integer id, Model model) {
        Foo foo = fooService.getOne(id);
        model.addAttribute("foo", foo);
        return "foo/form";
    }

    @PutMapping("/foo")
    public String updateFoo(Foo foo) {
        fooService.saveOrUpdate(foo);
        return "redirect:/foos";
    }

    @DeleteMapping("/foo/{id}")
    public String deleteFoo(@PathVariable("id") Integer id) {
        fooService.delete(id);
        return "redirect:/foos";
    }
}
