package com.joesalt.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joesalt.tutorial.model.Category;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = "SELECT * FROM categories WHERE category_name = ?1", nativeQuery = true)
    List<Category> getCategoriesByName(String categoryName);
}