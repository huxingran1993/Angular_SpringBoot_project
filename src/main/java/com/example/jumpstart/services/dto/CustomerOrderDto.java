package com.example.jumpstart.services.dto;

import com.example.jumpstart.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
//generate constructor with args
@NoArgsConstructor
@Data
//generate getter & setter for data

public class CustomerOrderDto {
    long id;
    String firstName;
    String lastName;
    double totalCost;
    List<OrderDto> orders;
}
