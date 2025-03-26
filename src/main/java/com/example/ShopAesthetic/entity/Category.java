package com.example.ShopAesthetic.entity;
import jakarta.persistence.*;

import java.util.List;
import java.time.LocalDateTime;
@Table(
        name = "Category"
)
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String slug;
    private String image;

    private LocalDateTime creationAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)

    private List<Product> products;

    public Category(){}
    public Category(Long id, String name, String slug, String image, LocalDateTime creationAt, LocalDateTime updatedAt, List<Product> products) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.image = image;
        this.creationAt = creationAt;
        this.updatedAt = updatedAt;
        this.products = products;
    }
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSlug(){
        return slug;
    }
    public void setSlug(String slug)
    {
        this.slug = slug;
    }

    public String getImage(){
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }
    public LocalDateTime getCreationAt() {
        return creationAt;
    }

    public void setCreationAt(LocalDateTime creationAt) {
        this.creationAt = creationAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
