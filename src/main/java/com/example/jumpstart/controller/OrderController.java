package com.example.jumpstart.controller;

import com.example.jumpstart.exception.ResourceNotFoundException;
import com.example.jumpstart.model.Customer;
import com.example.jumpstart.model.Order;
import com.example.jumpstart.services.CustomerService;
import com.example.jumpstart.services.OrderService;
import com.example.jumpstart.services.dto.CustomerOrderDto;
import com.example.jumpstart.services.dto.OrderDto;
import com.example.jumpstart.services.impl.OrderServiceImpl;
import com.example.jumpstart.services.mapper.CustomerMapper;
import com.example.jumpstart.services.mapper.OrderMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
//this annotation handling all incoming http request
@RequestMapping("/api/orders")

public class OrderController {
    private final OrderService orderService;
    private final CustomerService customerService;

    public OrderController(OrderServiceImpl orderService, CustomerService customerService) {
        this.orderService = orderService;
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity getAllOrders(){
        List<Customer> allCustomer = customerService.getAll();
        List<CustomerOrderDto> result = new ArrayList<>();
        for (Customer c:allCustomer){
            CustomerOrderDto dto = CustomerMapper.toCustomerOrderDto(c,orderService.getOrdersByCustomerId( c.getId()));
            result.add(dto);
        }
        return ResponseEntity.ok(result);
    }


    @GetMapping("/{customerId}")
    public List<OrderDto> getOrdersByCustomerId(@PathVariable(value = "customerId") long customerId){
        return OrderMapper.toOrderDto(orderService.getOrdersByCustomerId(customerId));
    }

    @PostMapping("/{customerId}")
    public Order addOrder(@PathVariable(value = "customerId") long customerId, @Valid @RequestBody Order order){
        Customer customer = customerService.getById(customerId).orElseThrow(
                ()->new ResourceNotFoundException("Customer ID: " + customerId +" not find." ));
            order.setCustomer(customer);
            return orderService.createOrder(order);
    }


}
