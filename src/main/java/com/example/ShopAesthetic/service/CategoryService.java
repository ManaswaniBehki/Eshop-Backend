package com.example.ShopAesthetic.service;

import com.example.ShopAesthetic.dto.CategoryDto;
import com.example.ShopAesthetic.entity.Category;
import java.util.List;
public interface CategoryService {
    List<CategoryDto> getAllCategories();
    CategoryDto getCategoryById(Long id);
    CategoryDto addCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(Long id, CategoryDto categoryDto);
    void deleteCategory(Long id);
}
