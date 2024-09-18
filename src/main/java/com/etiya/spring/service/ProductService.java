package com.etiya.spring.service;


import com.etiya.spring.dto.product.CreateProductRequestDto;
import com.etiya.spring.dto.product.CreateProductResponseDto;
import com.etiya.spring.dto.product.ListProductDto;
import com.etiya.spring.entity.Product;

import java.util.List;


public interface ProductService {

    List<ListProductDto> getAll();
    Product getById(int id);
    CreateProductResponseDto add(CreateProductRequestDto createProductRequestDto);
    void delete(int id);
    Product update(Product product);
}
