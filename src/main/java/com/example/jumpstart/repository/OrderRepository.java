package com.example.jumpstart.repository;

import com.example.jumpstart.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderRepository extends JpaRepository<Order, Long> {
    //Page<Order> findByCustomerId(long customerId, Pageable pageable);
    List<Order> findByCustomerId(long customerId);
    Optional<Order> findByIdAndCustomerId(long id, long customerId);
    List<Order> findAllByCustomerId(long customerId);

}
