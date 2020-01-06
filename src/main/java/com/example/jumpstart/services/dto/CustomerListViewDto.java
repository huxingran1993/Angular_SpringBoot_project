package com.example.jumpstart.services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
//generate constructor with args
@NoArgsConstructor
@Data
//generate getter & setter for data

public class CustomerListViewDto {
    long id;
    String firstName;
    String lastName;
    String gender;
    String address;
    String state;
    String city;
    double totalCost;
}
