package com.example.ShopAesthetic.dto;

import com.example.ShopAesthetic.entity.Category;
import java.util.List;

public class ProductDto {

    private Long id;
    private String title;
    private Double price;
    private String images;
    private String description;
    private CategoryDto category;  // CategoryDto for storing category information

    // Default constructor
    public ProductDto() {
    }

    // Constructor with all fields
    public ProductDto(Long id, String title, Double price, String images, String description, CategoryDto category) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.images = images;
        this.description = description;
        this.category = category;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }
}
