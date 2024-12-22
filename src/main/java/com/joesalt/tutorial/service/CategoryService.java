package com.joesalt.tutorial.service;

import com.joesalt.tutorial.model.Category;
import com.joesalt.tutorial.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category getCategory(long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Not Found"));
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Category updateProduct(long categoryId, Category category) {
        Category existingCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Not Found"));
        existingCategory.setCategoryName(category.getCategoryName());
        existingCategory.setDescription(category.getDescription());
        categoryRepository.save(existingCategory);
        return existingCategory;
    }

    public Category deletecategory(long categoryId) {
        Category existingCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Not Found"));
        categoryRepository.deleteById(categoryId);
        return existingCategory;
    }

    public List<Category> getCategoriesByName(String categoryName) {
        return categoryRepository.getCategoriesByName(categoryName);
    }
}