package com.etiya.spring.dto.product;

import com.etiya.spring.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListProductResponseDto
{
    private int id;
    private String name;
    private double unitPrice;
    private Category category;
}
