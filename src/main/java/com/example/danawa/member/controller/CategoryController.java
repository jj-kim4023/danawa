package com.example.danawa.member.controller;

import com.example.danawa.member.service.CategoryService;
import jdk.jfr.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<Category> findAll() {

        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable(value = "name") Long id) {

        return categoryService.findById(id);
    }

    @PostMapping
    public Category save(@RequestBody Category category) {

        return categoryService.save(category);
    }

    @GetMapping("/code/{code}")
    public Category findByCode(@PathVariable(value = "name") String code) {

        return categoryService.findByCode(code);
    }

}
