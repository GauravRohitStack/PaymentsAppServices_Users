package com.jbm.payments.app.service;

import com.jbm.payments.app.entity.Payment;

public interface PaymentService {

    Payment processPayment(Long orderId);

}