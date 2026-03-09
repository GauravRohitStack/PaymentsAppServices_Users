package com.jbm.payments.app.service.impl;

import com.jbm.payments.app.entity.Order;
import com.jbm.payments.app.entity.Payment;
import com.jbm.payments.app.repository.OrderRepository;
import com.jbm.payments.app.repository.PaymentRepository;
import com.jbm.payments.app.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository,
                              OrderRepository orderRepository) {
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Payment processPayment(Long orderId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        if (!order.getStatus().equals("CREATED")) {
            throw new RuntimeException("Order already processed");
        }

        // Simulate Payment Success
        Payment payment = new Payment();
        payment.setOrder(order);
        payment.setStatus("SUCCESS");
        payment.setPaymentReference("PAY-" + UUID.randomUUID());

        // Update Order Status
        order.setStatus("PAID");
        orderRepository.save(order);

        return paymentRepository.save(payment);
    }
}
