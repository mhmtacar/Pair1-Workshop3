package com.etiya.spring.service;

import com.etiya.spring.dto.product.*;
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
    public List<ListProductResponseDto> getAll() {
        List<Product> products = productRepository.getAll();
        return ProductMapper.INSTANCE.productFromListDto(products);
    }

    @Override
    public GetByIdProductResponseDto getById(int id) {
        Product product = productRepository.getById(id);
        return ProductMapper.INSTANCE.productFromGetByIdDto(product);
    }

    @Override
    public CreateProductResponseDto add(CreateProductRequestDto createProductRequestDto) {
        Product product = ProductMapper.INSTANCE.productFromCreateDto(createProductRequestDto);

        Random random = new Random();
        product.setId(random.nextInt(1, 99999));

        Product addedProduct = productRepository.add(product);

        return ProductMapper.INSTANCE.createProductResponseDtoFromProduct(addedProduct);
    }

    @Override
    public void delete(int id) { productRepository.delete(id); }

    @Override
    public UpdateProductResponseDto update(int id, UpdateProductRequestDto updateProductRequestDto) {

        Product product = ProductMapper.INSTANCE.productFromUpdateDto(updateProductRequestDto);
        Product updatedProduct = productRepository.update(id, product);
        return ProductMapper.INSTANCE.updateProductResponseDtoFromProduct(updatedProduct);
    }
}
