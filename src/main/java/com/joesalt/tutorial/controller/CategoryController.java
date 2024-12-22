package com.joesalt.tutorial.controller;

import com.joesalt.tutorial.model.Category;

import com.joesalt.tutorial.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // insert a product into database
    @PostMapping("/category")
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
        Category savedCategory = categoryService.saveCategory(category);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

    // get a single product by its id
    @GetMapping("/category")
    public ResponseEntity<Category> getCategory(@RequestParam(name = "categoryId") long categoryId) {
        Category category = categoryService.getCategory(categoryId);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    // get all the products in the table in our database
    @GetMapping("/categories")
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    // update an existing product in the database
    @PatchMapping("/category")
    public ResponseEntity<Category> updateCategory(@RequestParam(name = "categoryId") long categoryId,
            @RequestBody Category category) {
        Category updatedCategory = categoryService.updateProduct(categoryId, category);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    // delete an existing product in the database
    @DeleteMapping("/category")
    public ResponseEntity<Category> deleteCategory(@RequestParam(name = "productId") long categoryId) {
        Category deletedCategory = categoryService.deletecategory(categoryId);
        return new ResponseEntity<>(deletedCategory, HttpStatus.OK);
    }

    // get product by name using a raw SQL statement
    @GetMapping("/categories-by-name")
    public List<Category> getCategoriesByName(@RequestParam(name = "categoryName") String categoryName) {
        return categoryService.getCategoriesByName(categoryName);
    }

}