package com.example.jumpstart.services.mapper;

import com.example.jumpstart.model.Customer;
import com.example.jumpstart.model.Order;
import com.example.jumpstart.services.dto.*;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerMapper {

    public static List<CustomerBasicDto> toCardViewDto(List<Customer> customers) {
         return customers.stream().map(c -> new CustomerBasicDto(
                    c.getId(),
                    c.getFirstName(),
                    c.getLastName(),
                    c.getGender(),
                    c.getState(),
                    c.getCity())).collect(Collectors.toList());
    }

    public static Customer toModel(CreateCustomerDto customer){
        return Customer.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .gender(customer.getGender())
                .city(customer.getCity())
                .state(customer.getState())
                .address(customer.getAddress())
                .build();
    }


    public static CustomerOrderDto toCustomerOrderDto(Customer customer, List<Order> orders) {
        double sum = 0;
        for (Order o:orders){
            sum += o.getItemCost();
        }
        return new CustomerOrderDto(customer.getId(),customer.getFirstName(),customer.getLastName(), sum, OrderMapper.toOrderDto(orders));
    }

    public static CustomerListViewDto toCustomerListViewDto(Customer customer, List<Order> orders){
        double sum = 0;
        for (Order o:orders){
            sum += o.getItemCost();
        }
        return new  CustomerListViewDto(customer.getId(),
                    customer.getFirstName(),
                    customer.getLastName(),
                    customer.getGender(),
                    customer.getAddress(),
                    customer.getState(),
                    customer.getCity(),
                    sum);
    }
}
