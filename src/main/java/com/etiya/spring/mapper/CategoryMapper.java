package com.etiya.spring.mapper;

import com.etiya.spring.dto.category.*;

import com.etiya.spring.entity.Category;

import org.mapstruct.factory.Mappers;

import java.util.List;

public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category categoryFromCreateDto(CreateCategoryRequestDto dto);
    CreateCategoryResponseDto createCategoryResponseDtoFromCategory(Category category);
    List<ListCategoryResponseDto> categoryFromListDto(List<Category> dto);
    Category categoryFromUpdateDto(UpdateCategoryRequestDto dto);
    UpdateCategoryResponseDto updateCategoryResponseDtoFromCategory(Category category);
    GetByIdCategoryResponseDto categoryFromGetByIdDto(Category category);
}
