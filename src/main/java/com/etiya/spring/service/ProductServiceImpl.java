package com.etiya.spring.service;

import com.etiya.spring.dto.product.*;
import com.etiya.spring.entity.Product;
import com.etiya.spring.mapper.ProductMapper;
import com.etiya.spring.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    @Override
    public List<ListProductResponseDto> getAll() {
        List<Product> products = productRepository.getAll();
        return ProductMapper.INSTANCE.productFromListDto(products);
    }

    @Override
    public Product getById(int id) {
        return productRepository.getById(id);
    }

    @Override
    public CreateProductResponseDto add(CreateProductRequestDto createProductRequestDto) {
        Product product = ProductMapper.INSTANCE.productFromCreateDto(createProductRequestDto);
        Product addedProduct = productRepository.add(product);

        return ProductMapper.INSTANCE.createProductResponseDtoFromProduct(addedProduct);
    }

    @Override
    public void delete(int id) { productRepository.delete(id); }

    @Override
    public UpdateProductResponseDto update(UpdateProductRequestDto updateProductRequestDto) {
        Product product = ProductMapper.INSTANCE.productFromUpdateDto(updateProductRequestDto);
        Product updatedProduct = productRepository.update(product);
        return ProductMapper.INSTANCE.updateProductResponseDtoFromProduct(updatedProduct);
    }
}
