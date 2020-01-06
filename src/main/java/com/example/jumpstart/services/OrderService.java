package com.example.jumpstart.services;

import com.example.jumpstart.model.Order;
import org.aspectj.weaver.ast.Or;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface OrderService {
    List<Order> getAll();
    List<Order> getOrdersByCustomerId(long customerId);
    Order createOrder(Order order);
}
