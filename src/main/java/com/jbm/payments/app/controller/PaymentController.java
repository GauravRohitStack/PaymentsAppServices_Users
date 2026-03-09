package com.jbm.payments.app.controller;

import com.jbm.payments.app.entity.Payment;
import com.jbm.payments.app.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "http://localhost:5173")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // Simulate Payment
    @PostMapping("/{orderId}")
    public ResponseEntity<Payment> processPayment(
            @PathVariable Long orderId) {

        return ResponseEntity.ok(
                paymentService.processPayment(orderId)
        );
    }
}