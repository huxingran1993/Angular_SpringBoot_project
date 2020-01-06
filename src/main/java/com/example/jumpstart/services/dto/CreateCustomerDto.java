package com.example.jumpstart.services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
//generate constructor with args
@NoArgsConstructor
@Data
public class CreateCustomerDto {
        long id;
        String firstName;
        String lastName;
        String gender;
        String state;
        String city;
        String address;
}
