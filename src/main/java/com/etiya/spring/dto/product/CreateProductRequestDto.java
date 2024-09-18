package com.etiya.spring.dto.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequestDto
{
    // Ürün ekleme işleminde gerekli alanları tanımlayabileceğim nesne.
    private String name;
    private double unitPrice;
    private int unitsInStock;
}
