package com.etiya.spring.service.product;

import com.etiya.spring.core.exception.type.BusinessException;
import com.etiya.spring.dto.product.*;
import com.etiya.spring.entity.Category;
import com.etiya.spring.entity.Product;
import com.etiya.spring.mapper.ProductMapper;
import com.etiya.spring.repository.category.CategoryRepository;
import com.etiya.spring.repository.product.ProductRepository;
import com.etiya.spring.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
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
        Category category = categoryRepository.getById(createProductRequestDto.getCategoryId());
        Random random = new Random();
        product.setId(random.nextInt(1, 99));
        product.setCategory(category);
//        category.getProductList().add(product);
//        List<Product> categories = category.getProductList();
//        categories.add(product);
//        category.setProductList(categories);

        Product addedProduct = productRepository.add(product);

        return ProductMapper.INSTANCE.createProductResponseDtoFromProduct(addedProduct);
    }

    @Override
    public void delete(int id) { productRepository.delete(id); }

    @Override
    public UpdateProductResponseDto update(int id, UpdateProductRequestDto updateProductRequestDto) {

        Product product = ProductMapper.INSTANCE.productFromUpdateDto(updateProductRequestDto);

        boolean productWithSameData = productRepository.getAll()
                .stream()
                .anyMatch(_product ->
                        _product.getName().equals(product.getName()) &&
                                _product.getUnitPrice() == product.getUnitPrice() &&
                                _product.getUnitsInStock() == product.getUnitsInStock()
                );

        if(productWithSameData)
            throw new BusinessException("Güncellenen ürün eski ürünle aynı olamaz!.");

        double oldProductPrice = productRepository.getById(id).getUnitPrice();
        double newProductPrice = product.getUnitPrice();

        if(newProductPrice > (oldProductPrice*1.5)){
            throw new BusinessException("Ürün fiyatını %50'den fazla arttıramazsın!");
        }

        Product updatedProduct = productRepository.update(id, product);
        return ProductMapper.INSTANCE.updateProductResponseDtoFromProduct(updatedProduct);
    }
}
