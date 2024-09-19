package com.etiya.spring.service.product;


import com.etiya.spring.dto.product.*;
import com.etiya.spring.entity.Product;

import java.util.List;


public interface ProductService {

    List<ListProductResponseDto> getAll();
    GetByIdProductResponseDto getById(int id);
    CreateProductResponseDto add(CreateProductRequestDto createProductRequestDto);
    void delete(int id);
    UpdateProductResponseDto update(int id, UpdateProductRequestDto updateProductRequestDto);
}
