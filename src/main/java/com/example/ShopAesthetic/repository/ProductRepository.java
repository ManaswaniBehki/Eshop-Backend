package com.example.ShopAesthetic.repository;

import com.example.ShopAesthetic.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryId(Long categoryId);
    List<Product> findByTitleContainingIgnoreCase(String title);
}
