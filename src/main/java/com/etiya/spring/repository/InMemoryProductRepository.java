package com.etiya.spring.repository;

import com.etiya.spring.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProductRepository implements ProductRepository{

    List<Product> products = new ArrayList<>();
    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product getById(int id) {
        for(Product product: products){
           if(product.getId() == id) {
               return product;
           }
        }
        return null;
    }

    @Override
    public Product add(Product product) {
        products.add(product);
        return product;
    }

    @Override
    public void delete(int id) {
        products.removeIf(product -> product.getId() == id);
    }

    @Override
    public Product update(Product product) {
        for(Product _product: products){
            if(_product.getId() == product.getId()) {
                _product.setName(product.getName());
                _product.setUnitPrice(product.getUnitPrice());
                _product.setUnitsInStock(product.getUnitsInStock());
                return _product;
            }
        }
        return null;
    }
}
