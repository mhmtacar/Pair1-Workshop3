package com.etiya.spring.controller;

import com.etiya.spring.dto.product.*;
import com.etiya.spring.entity.Product;
import com.etiya.spring.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductService productService;

    @GetMapping
    public List<ListProductResponseDto> getAll(){
        return productService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<GetByIdProductResponseDto> getById(@PathVariable int id){
        GetByIdProductResponseDto product = productService.getById(id);

        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PostMapping
    public ResponseEntity<CreateProductResponseDto> add(@RequestBody CreateProductRequestDto createProductRequestDto){
        CreateProductResponseDto createProductResponseDto = productService.add(createProductRequestDto);

        if (createProductResponseDto != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createProductResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        GetByIdProductResponseDto product = productService.getById(id);

        if (product != null) {
            productService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<UpdateProductResponseDto> update(@PathVariable int id, @RequestBody UpdateProductRequestDto updateProductRequestDto){
        UpdateProductResponseDto _product = productService.update(id, updateProductRequestDto);

        if (_product != null) {
            return ResponseEntity.ok(_product);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
