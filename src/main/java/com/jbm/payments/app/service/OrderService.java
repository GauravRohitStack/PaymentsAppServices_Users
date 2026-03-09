package com.jbm.payments.app.service;

import com.jbm.payments.app.entity.Order;
import java.util.List;

public interface OrderService {

    Order createOrder(Long userId, Long productId, int quantity);

    List<Order> getAllOrders();

    Order getOrderById(Long id);

    Order updateOrderStatus(Long orderId, String status);
}