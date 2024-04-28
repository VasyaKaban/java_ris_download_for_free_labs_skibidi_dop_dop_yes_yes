package com.vk.shop.business.abstracts;

import com.vk.shop.entities.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    Category save(Category category);

}
