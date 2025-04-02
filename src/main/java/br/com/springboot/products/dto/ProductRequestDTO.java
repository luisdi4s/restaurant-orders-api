package br.com.springboot.products.dto;

import br.com.springboot.products.model.ProductCategory;
import br.com.springboot.products.model.ProductSubCategory;
import jakarta.annotation.Nullable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDTO {
    @NotBlank
    @Size(min = 3, max = 100)
    private String name;

    @PositiveOrZero
    private Double price;

    @Min(0)
    private Integer stock;

    private String description;

    @Nullable
    private ProductCategory category;

    @Nullable
    private ProductSubCategory subCategory;
}