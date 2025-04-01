package br.com.springboot.products.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 100, message = "Name must be 3-100 characters")
    private String name;

    @PositiveOrZero(message = "Price must be positive or zero")
    private Double price;

    @Min(value = 0, message = "Stock cannot be negative")
    private Integer stock;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private ProductCategory mainCategory;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private ProductSubCategory subCategory;
}