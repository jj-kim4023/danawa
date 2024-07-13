package com.example.danawa.member.service;

import com.example.danawa.member.repository.CategoryRepository;
import jdk.jfr.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public List<Category> findByParentId(Long parentId) {
        return categoryRepository.findByParentId(parentId);
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Category findByCode(String code) {
        return categoryRepository.findByCode(code).orElse(null);
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(()->new IllegalArgumentException("잘못된 접근입니다"));
    }
}
