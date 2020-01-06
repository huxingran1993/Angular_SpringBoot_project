package com.example.jumpstart.services;

import com.example.jumpstart.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> getAll();

    //Option throws exceptions when there is no customer
    Optional<Customer> getById(long id);

    Customer createCustomer(Customer customer);

    Boolean update(Customer customer);
}
