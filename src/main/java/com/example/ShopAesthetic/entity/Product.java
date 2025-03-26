package com.example.ShopAesthetic.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "products")
@Entity
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private String images;

    @Column(nullable = false)
    private String description;



    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;


    // Constructors, Getters, Setters
    public Product() {}

    public Product(Long id, String title, Double price, String images, String description, Category category) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.images = images;
        this.description = description;
//        this.creationAt = creationAt;
//        this.updatedAt = updatedAt;
        this.category = category;
    }



    // Getter and Setter methods for the fields
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
//
//    public LocalDateTime getCreationAt() {
//        return creationAt;
//    }

//    public void setCreationAt(LocalDateTime creationAt) {
//        this.creationAt = creationAt;
//    }

//    public LocalDateTime getUpdatedAt() {
//        return updatedAt;
//    }

//    public void setUpdatedAt(LocalDateTime updatedAt) {
//        this.updatedAt = updatedAt;
//    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
