package com.example.ShopAesthetic.service;

import com.example.ShopAesthetic.dto.ProductDto;
import com.example.ShopAesthetic.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();

    ProductDto getProductById(Long id);
    List<ProductDto> getProductsByCategories(Long CategoryId);

    ProductDto addProduct(ProductDto productDto, Long CategoryId);

    ProductDto updateProduct(Long id, ProductDto productDto);

    void deleteProduct(Long id);
}
