package com.vk.shop.controllers;

import com.vk.shop.business.abstracts.CategoryService;
import com.vk.shop.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories/")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("getall")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @PostMapping("save")
    public Category save(@RequestBody Category category){
        return categoryService.save(category);
    }
}
