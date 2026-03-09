package com.jbm.payments.app.dto;

import java.time.LocalDateTime;

public class OrderDTO {

    private Long id;
    private String productName;
    private int quantity;
    private double totalAmount;
    private String status;
    private LocalDateTime orderDate;

    public OrderDTO() {}

    public OrderDTO(Long id,
                    String productName,
                    int quantity,
                    double totalAmount,
                    String status,
                    LocalDateTime orderDate) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.status = status;
        this.orderDate = orderDate;
    }

    public Long getId() { return id; }

    public String getProductName() { return productName; }

    public int getQuantity() { return quantity; }

    public double getTotalAmount() { return totalAmount; }

    public String getStatus() { return status; }

    public LocalDateTime getOrderDate() { return orderDate; }
}