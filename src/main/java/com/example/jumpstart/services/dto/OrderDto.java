package com.example.jumpstart.services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
//generate constructor with args
@NoArgsConstructor
@Data
public class OrderDto {
    String productName;
    double itemCost;
}
