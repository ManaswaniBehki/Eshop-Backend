package com.example.ShopAesthetic.service.impl;

import com.example.ShopAesthetic.dto.ProductDto;
import com.example.ShopAesthetic.dto.CategoryDto;
import com.example.ShopAesthetic.entity.Product;
import com.example.ShopAesthetic.entity.Category;
import com.example.ShopAesthetic.exceptionHandling.ResourceNotFoundException;
import com.example.ShopAesthetic.repository.ProductRepository;
import com.example.ShopAesthetic.repository.CategoryRepository;
import com.example.ShopAesthetic.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    // Fetch all products
    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Fetch a product by its ID
    @Override
    public ProductDto getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with ID " + id + " not found"));
        return convertToDTO(product);
    }

    // Add a new product with a specific category
    @Override
    public ProductDto addProduct(ProductDto productDto, Long categoryId) {
        // Fetch the Category by categoryId
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category with ID " + categoryId + " not found"));

        // Convert ProductDto to Product entity
        Product product = convertToEntity(productDto);

        // Set the category to the Product entity
        product.setCategory(category);

        // Save the product
        Product savedProduct = productRepository.save(product);

        // Return the saved product as a ProductDto
        return convertToDTO(savedProduct);
    }

    // Fetch products based on category ID
    @Override
    public List<ProductDto> getProductsByCategories(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category with ID " + categoryId + " not found"));

        List<Product> products = productRepository.findByCategoryId(categoryId);
        return products.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Update an existing product
    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with ID " + id + " not found"));

        existingProduct.setTitle(productDto.getTitle());
        existingProduct.setPrice(productDto.getPrice());
        existingProduct.setImages(productDto.getImages());
        existingProduct.setDescription(productDto.getDescription());

        // If the category is provided, update the product's category
        if (productDto.getCategory() != null) {
            Category category = categoryRepository.findById(productDto.getCategory().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
            existingProduct.setCategory(category);
        }

        Product updatedProduct = productRepository.save(existingProduct);
        return convertToDTO(updatedProduct);
    }

    // Delete a product by its ID
    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    // Helper method to convert Product entity to ProductDto
    private ProductDto convertToDTO(Product product) {
        Category category = product.getCategory();
        CategoryDto categoryDto = (category != null)
                ? new CategoryDto(category.getId(), category.getName(), category.getSlug(), category.getImage())
                : null;

        return new ProductDto(
                product.getId(),
                product.getTitle(),
                product.getPrice(),
                product.getImages(),
                product.getDescription(),
                categoryDto
        );
    }

    // Helper method to convert ProductDto to Product entity
    private Product convertToEntity(ProductDto productDto) {
        Category category = categoryRepository.findById(productDto.getCategory().getId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        return new Product(
                productDto.getId(),
                productDto.getTitle(),
                productDto.getPrice(),
                productDto.getImages(),
                productDto.getDescription(),
                category
        );
    }
}
