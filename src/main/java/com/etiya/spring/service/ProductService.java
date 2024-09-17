package com.etiya.spring.service;

import com.etiya.spring.entity.Product;

import java.util.List;


public interface ProductService {

    List<Product> getAll();
    Product getById(int id);
    Product add(Product product);
    void delete(int id);
    Product update(Product product);
}
