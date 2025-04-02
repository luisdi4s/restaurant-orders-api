package br.com.springboot.products.service;

import br.com.springboot.products.dto.ProductRequestDTO;
import br.com.springboot.products.dto.ProductResponseDTO;
import br.com.springboot.products.model.Product;
import br.com.springboot.products.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public ProductResponseDTO createProduct(ProductRequestDTO request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());

        if (request.getCategory() != null) {
            product.setCategory(request.getCategory());
        }
        if (request.getSubCategory() != null) {
            product.setSubCategory(request.getSubCategory());
        }

        Product savedProduct = repository.save(product);
        return mapToResponse(savedProduct);
    }

    public List<ProductResponseDTO> getAllProducts() {
        return repository.findAll().stream()
                .map(this::mapToResponse)
                .toList();
    }

    private ProductResponseDTO mapToResponse(Product product) {
        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getStock(),
                product.getCategory(),
                product.getSubCategory()
        );
    }
}
