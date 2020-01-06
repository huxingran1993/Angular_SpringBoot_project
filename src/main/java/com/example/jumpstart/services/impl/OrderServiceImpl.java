package com.example.jumpstart.services.impl;

import com.example.jumpstart.model.Order;
import com.example.jumpstart.repository.OrderRepository;
import com.example.jumpstart.services.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getOrdersByCustomerId(long customerId) {
        return  orderRepository.findByCustomerId(customerId);
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }


}
