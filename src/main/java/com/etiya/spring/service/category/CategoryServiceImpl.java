package com.etiya.spring.service.category;

import com.etiya.spring.core.exception.type.BusinessException;
import com.etiya.spring.dto.category.*;
import com.etiya.spring.entity.Category;
import com.etiya.spring.mapper.CategoryMapper;
import com.etiya.spring.repository.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    @Override
    public List<ListCategoryResponseDto> getAll() {
        List<Category> categories = categoryRepository.getAll();
        return CategoryMapper.INSTANCE.categoryFromListDto(categories);
    }

    @Override
    public GetByIdCategoryResponseDto getById(int id) {
        Category category = categoryRepository.getById(id);
        return CategoryMapper.INSTANCE.categoryFromGetByIdDto(category);
    }

    @Override
    public CreateCategoryResponseDto add(CreateCategoryRequestDto createCategoryRequestDto) {
        Category category = CategoryMapper.INSTANCE.categoryFromCreateDto(createCategoryRequestDto);

        Random random = new Random();
        category.setId(random.nextInt(1, 9));

        Category addedCategory = categoryRepository.add(category);

        return CategoryMapper.INSTANCE.createCategoryResponseDtoFromCategory(addedCategory);
    }

    @Override
    public void delete(int id) {
        categoryRepository.delete(id);
    }

    @Override
    public UpdateCategoryResponseDto update(int id, UpdateCategoryRequestDto updateCategoryRequestDto) {
        Category category = CategoryMapper.INSTANCE.categoryFromUpdateDto(updateCategoryRequestDto);

        boolean categoryWithSameName = categoryRepository.getAll()
                .stream()
                .anyMatch(_category -> _category.getName().equals(updateCategoryRequestDto.getName()));

        if(categoryWithSameName)
            throw new BusinessException("Böyle bir kategori zaten var.");


        Category updatedCategory = categoryRepository.update(id, category);
        return CategoryMapper.INSTANCE.updateCategoryResponseDtoFromCategory(updatedCategory);
    }
}
