package com.etiya.spring.service.category;

import com.etiya.spring.dto.category.*;

import java.util.List;

public interface CategoryService {
    List<ListCategoryResponseDto> getAll();
    GetByIdCategoryResponseDto getById(int id);
    CreateCategoryResponseDto add(CreateCategoryRequestDto createCategoryRequestDto);
    void delete(int id);
    UpdateCategoryResponseDto update(int id, UpdateCategoryRequestDto updateCategoryRequestDto);
}
