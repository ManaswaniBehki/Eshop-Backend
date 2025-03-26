package com.example.ShopAesthetic.repository;

import com.example.ShopAesthetic.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
