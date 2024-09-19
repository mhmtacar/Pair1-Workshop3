package com.etiya.spring.dto.product;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductRequestDto {
    //int id;
    @NotEmpty
    private String name;
    @Positive
    private double unitPrice;
    @PositiveOrZero
    private int unitsInStock;
}
