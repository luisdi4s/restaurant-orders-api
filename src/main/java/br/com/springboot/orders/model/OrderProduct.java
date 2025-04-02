package br.com.springboot.orders.model;

import br.com.springboot.products.model.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

    @NotBlank(message = "Quantity is required")
    private Double quantity;

    @NotBlank(message = "Unit price is required")
    private Double unitPrice;

    @Column(nullable = true)
    private boolean ready;
}
