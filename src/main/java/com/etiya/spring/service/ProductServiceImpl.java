package com.etiya.spring.service;

import com.etiya.spring.dto.product.CreateProductRequestDto;
import com.etiya.spring.dto.product.CreateProductResponseDto;
import com.etiya.spring.dto.product.ListProductDto;
import com.etiya.spring.entity.Product;
import com.etiya.spring.mapper.ProductMapper;
import com.etiya.spring.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    @Override
    public List<ListProductDto> getAll() {
        List<Product> products = productRepository.getAll();
        return ProductMapper.INSTANCE.productFromListDto(products);
    }

    @Override
    public Product getById(int id) {
        return productRepository.getById(id);
    }

    @Override
    public Product add(CreateProductRequestDto createProductRequestDto) {
        Product product = ProductMapper.INSTANCE.productFromCreateDto(createProductRequestDto);
        return productRepository.add(product);
        //return ProductMapper.INSTANCE.createProductResponseDtoFromProduct(productRepository.add(product));
    }

    @Override
    public void delete(int id) { productRepository.delete(id); }

    @Override
    public Product update(Product product) {
        return productRepository.update(product);
    }
}
