package com.etiya.spring.mapper;

import com.etiya.spring.dto.product.*;
import com.etiya.spring.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper
{
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product productFromCreateDto(CreateProductRequestDto dto);
    CreateProductResponseDto createProductResponseDtoFromProduct(Product product);
    List<ListProductDto> productFromListDto(List<Product> dto);
    Product productFromUpdateDto(UpdateProductDto dto);

}
// Global Exception Handling
// Spring Validation ile Validasyon
