package com.jbm.payments.app.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ======================
    // Many Orders -> One User
    // ======================
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // ======================
    // Many Orders -> One Product
    // ======================
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private int quantity;

    private double totalAmount;

    private String status; // CREATED, PAID, FAILED

    private LocalDateTime orderDate;

    // ======================
    // Constructors
    // ======================

    public Order() {
        this.orderDate = LocalDateTime.now();
        this.status = "CREATED";
    }

    // ======================
    // Getters & Setters
    // ======================

    public Long getId() { return id; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Product getProduct() { return product; }

    public void setProduct(Product product) { this.product = product; }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getTotalAmount() { return totalAmount; }

    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getOrderDate() { return orderDate; }
}