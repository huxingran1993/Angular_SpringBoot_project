package com.example.jumpstart.services.dto;

import com.example.jumpstart.model.Order;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

//@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
//generate constructor with args
@NoArgsConstructor
@Data
//generate getter & setter for data
public class CustomerBasicDto {

    long id;
    String firstName;
    String lastName;
    String gender;
    String state;
    String city;
}
