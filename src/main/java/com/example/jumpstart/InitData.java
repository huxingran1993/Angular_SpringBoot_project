package com.example.jumpstart;

import com.example.jumpstart.model.Customer;
import com.example.jumpstart.repository.CustomerRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitData {
    private final CustomerRepository customerRepository;

    public InitData(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostConstruct
    public void seed(){
        customerRepository.save(new Customer(1L, "Xi", "JingPing", "male", "Zhongnanhai road", "Pekin", "Iowa", 11.11, 11.11));

           }
}
