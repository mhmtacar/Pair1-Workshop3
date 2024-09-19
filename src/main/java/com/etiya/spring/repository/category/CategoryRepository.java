package com.etiya.spring.repository.category;

import com.etiya.spring.entity.Category;
import com.etiya.spring.entity.Product;

import java.util.List;

public interface CategoryRepository {
    List<Category> getAll();
    Category getById(int id);
    Category add(Category category);
    void delete(int id);
    Category update(int id, Category category);
}
