package com.jbm.payments.app.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // One Payment → One Order
    @OneToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    private String paymentReference;

    private String status; // SUCCESS, FAILED

    private LocalDateTime paymentDate;

    // ======================
    // Constructor
    // ======================

    public Payment() {
        this.paymentDate = LocalDateTime.now();
    }

    // ======================
    // Getters & Setters
    // ======================

    public Long getId() { return id; }

    public Order getOrder() { return order; }

    public void setOrder(Order order) { this.order = order; }

    public String getPaymentReference() { return paymentReference; }

    public void setPaymentReference(String paymentReference) {
        this.paymentReference = paymentReference;
    }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getPaymentDate() { return paymentDate; }
}