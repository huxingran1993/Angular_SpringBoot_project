package com.example.jumpstart.repository;

import com.example.jumpstart.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
