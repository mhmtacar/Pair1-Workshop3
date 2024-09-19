package com.etiya.spring.controller;

import com.etiya.spring.dto.category.*;
import com.etiya.spring.service.category.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoriesController {

    private final CategoryService categoryService;

    @GetMapping
    public List<ListCategoryResponseDto> getAll(){
        return categoryService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<GetByIdCategoryResponseDto> getById(@PathVariable int id){
        GetByIdCategoryResponseDto category = categoryService.getById(id);

        if (category != null) {
            return ResponseEntity.ok(category);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PostMapping
    public ResponseEntity<CreateCategoryResponseDto> add(@RequestBody @Valid CreateCategoryRequestDto createCategoryRequestDto){
        CreateCategoryResponseDto createCategoryResponseDto = categoryService.add(createCategoryRequestDto);

        if (createCategoryResponseDto != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createCategoryResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        GetByIdCategoryResponseDto category = categoryService.getById(id);

        if (category != null) {
            categoryService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<UpdateCategoryResponseDto> update(@PathVariable int id, @RequestBody @Valid UpdateCategoryRequestDto updateCategoryRequestDto){
        UpdateCategoryResponseDto _category = categoryService.update(id, updateCategoryRequestDto);

        if (_category != null) {
            return ResponseEntity.ok(_category);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
