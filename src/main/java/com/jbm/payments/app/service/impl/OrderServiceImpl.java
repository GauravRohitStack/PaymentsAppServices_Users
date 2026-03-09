package com.jbm.payments.app.service.impl;

import com.jbm.payments.app.dto.OrderDTO;
import com.jbm.payments.app.entity.Order;
import com.jbm.payments.app.entity.Product;
import com.jbm.payments.app.entity.User;
import com.jbm.payments.app.exception.ResourceNotFoundException;
import com.jbm.payments.app.repository.OrderRepository;
import com.jbm.payments.app.repository.ProductRepository;
import com.jbm.payments.app.repository.UserRepository;
import com.jbm.payments.app.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public OrderServiceImpl(OrderRepository orderRepository,
                            ProductRepository productRepository,
                            UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    // ======================
    // Create Order
    // ======================
    @Override
    public Order createOrder(Long userId, Long productId, int quantity) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Product product = productRepository.findById(productId)
//                .orElseThrow(() -> new RuntimeException("Product not found"));
        		.orElseThrow(() -> new ResourceNotFoundException("Order not found"));

        if (product.getStock() < quantity) {
            throw new RuntimeException("Not enough stock available");
        }

        Order order = new Order();
        order.setUser(user);
        order.setProduct(product);
        order.setQuantity(quantity);

        double totalAmount = product.getPrice() * quantity;
        order.setTotalAmount(totalAmount);

        // reduce stock
        product.setStock(product.getStock() - quantity);
        productRepository.save(product);

        return orderRepository.save(order);
    }
    
    
    
    

//    // ======================
//    @Override
//    public List<Order> getAllOrders() {
//        return orderRepository.findAll();
//    }
//    
    
    @Override
    public List getAllOrders() {

        return orderRepository.findAll()
                .stream()
                .map(order -> new OrderDTO(
                        order.getId(),
                        order.getProduct().getName(),
                        order.getQuantity(),
                        order.getTotalAmount(),
                        order.getStatus(),
                        order.getOrderDate()
                ))
                .toList();
    }
    
    
   

    // ======================
    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Order not found"));
        		.orElseThrow(() -> new ResourceNotFoundException("Order not found"));
    }

    // ======================
    @Override
    public Order updateOrderStatus(Long orderId, String status) {

        Order order = getOrderById(orderId);
        order.setStatus(status);
        return orderRepository.save(order);
    }
}