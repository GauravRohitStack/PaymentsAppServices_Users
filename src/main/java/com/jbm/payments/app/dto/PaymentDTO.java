package com.jbm.payments.app.dto;

import java.time.LocalDateTime;

public class PaymentDTO {

    private Long id;
    private String paymentReference;
    private String status;
    private LocalDateTime paymentDate;

    public PaymentDTO() {}

    public PaymentDTO(Long id,
                      String paymentReference,
                      String status,
                      LocalDateTime paymentDate) {
        this.id = id;
        this.paymentReference = paymentReference;
        this.status = status;
        this.paymentDate = paymentDate;
    }

    public Long getId() { return id; }

    public String getPaymentReference() { return paymentReference; }

    public String getStatus() { return status; }

    public LocalDateTime getPaymentDate() { return paymentDate; }
}