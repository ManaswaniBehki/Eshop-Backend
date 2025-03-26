package com.example.ShopAesthetic.service.impl;

import com.example.ShopAesthetic.dto.CategoryDto;
import com.example.ShopAesthetic.entity.Category;
import com.example.ShopAesthetic.repository.CategoryRepository;
import com.example.ShopAesthetic.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        return convertToDTO(category);
    }

    private CategoryDto convertToDTO(Category category) {
        return new CategoryDto(category.getId(), category.getName(), category.getSlug(), category.getImage());
    }

    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setSlug(categoryDto.getSlug());
        category.setImage(categoryDto.getImage());

        Category savedCategory = categoryRepository.save(category);
        return convertToDTO(savedCategory);
    }

    @Override
    public CategoryDto updateCategory(Long id, CategoryDto categoryDto) {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        existingCategory.setName(categoryDto.getName());
        existingCategory.setSlug(categoryDto.getSlug());
        existingCategory.setImage(categoryDto.getImage());

        Category updatedCategory = categoryRepository.save(existingCategory);
        return convertToDTO(updatedCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new RuntimeException("Category not found");
        }
        categoryRepository.deleteById(id);
    }
}
