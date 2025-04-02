package br.com.springboot.orders.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 100, message = "Name must be 3-100 characters")
    private String clientName;

    @Column(nullable = true)
    private String clientId;

    @Column(nullable = true)
    @Size(min = 11, max = 11, message = "CPF must be valid if informed")
    private String cpf;

    @NotBlank(message = "toDeliver is a required field")
    private boolean toDeliver;

    @Column(nullable = true)
    private boolean delivered;

    @Column(nullable = true)
    @Size(min = 3, max = 150, message = "Name must be 3-100 characters")
    private String addressToDeliver;

    @NotBlank(message = "Payment method is required")
    private PaymentMethod paymentMethod;

    @Column(nullable = true)
    private Double total;

    @Column(nullable = true)
    private Double discount;

    private LocalDateTime orderDate;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderProduct> items = new ArrayList<>();

}
