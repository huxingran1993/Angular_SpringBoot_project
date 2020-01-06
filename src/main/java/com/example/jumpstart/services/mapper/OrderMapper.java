package com.example.jumpstart.services.mapper;

import com.example.jumpstart.model.Customer;
import com.example.jumpstart.model.Order;
import com.example.jumpstart.services.dto.CustomerOrderDto;
import com.example.jumpstart.services.dto.OrderDto;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {
    public static List<OrderDto> toOrderDto(List<Order> orders) {
        return orders.stream().map(order -> new OrderDto(order.getProductName(), order.getItemCost())).collect(Collectors.toList());
    }
}
