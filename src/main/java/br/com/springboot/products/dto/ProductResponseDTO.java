package br.com.springboot.products.dto;

import br.com.springboot.products.model.ProductCategory;
import br.com.springboot.products.model.ProductSubCategory;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDTO {
    private Long id;
    private String name;
    private Double price;
    private Integer stock;
    private ProductCategory category;
    private ProductSubCategory subcategory;
}
