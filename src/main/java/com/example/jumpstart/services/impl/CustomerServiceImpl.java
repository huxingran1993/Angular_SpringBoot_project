package com.example.jumpstart.services.impl;

import com.example.jumpstart.services.CustomerService;
import com.example.jumpstart.model.Customer;
import com.example.jumpstart.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getById(long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Boolean update(Customer customer) {
        return null;
    }
}
