package com.etiya.spring.repository.category;

import com.etiya.spring.entity.Category;
import com.etiya.spring.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryCategoryRepository implements CategoryRepository {

    List<Category> categories = new ArrayList<>();
    @Override
    public List<Category> getAll() {
        return categories;
    }

    @Override
    public Category getById(int id) {
        for(Category category: categories){
            if(category.getId() == id) {
                return category;
            }
        }
        return null;
    }

    @Override
    public Category add(Category category) {
        categories.add(category);
        return category;
    }

    @Override
    public void delete(int id) {
        categories.removeIf(category -> category.getId() == id);
    }

    @Override
    public Category update(int id, Category category) {
        for(Category _category: categories){
            if(_category.getId() == id) {
                _category.setName(category.getName());
                return _category;
            }
        }
        return null;
    }
}
