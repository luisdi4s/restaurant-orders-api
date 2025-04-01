package br.com.springboot.products.controller;

import br.com.springboot.products.dto.ProductRequestDTO;
import br.com.springboot.products.dto.ProductResponseDTO;
import br.com.springboot.products.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponseDTO createProduct(@Valid @RequestBody ProductRequestDTO request) {
        return productService.createProduct(request);
    }

    @GetMapping
    public List<ProductResponseDTO> getAllProducts() {
        return productService.getAllProducts();
    }
}
