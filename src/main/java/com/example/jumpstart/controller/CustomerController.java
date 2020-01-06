package com.example.jumpstart.controller;

import com.example.jumpstart.model.Customer;
import com.example.jumpstart.services.CustomerService;
import com.example.jumpstart.services.OrderService;
import com.example.jumpstart.services.dto.CreateCustomerDto;
import com.example.jumpstart.services.dto.CustomerListViewDto;
import com.example.jumpstart.services.impl.CustomerServiceImpl;
import com.example.jumpstart.services.mapper.CustomerMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;
    private final OrderService orderService;

    public CustomerController(CustomerServiceImpl customerService, OrderService orderService) {
        this.customerService = customerService;
        this.orderService = orderService;
    }

    @PostMapping()
    public ResponseEntity addCustomer(@RequestBody CreateCustomerDto customer){
        //@RequestBody check the body of the request
        Customer createdCustomer = customerService.createCustomer(CustomerMapper.toModel(customer));
        return ResponseEntity.created(URI.create("/api/customers/"+ createdCustomer.getId())).build();
        //response entity : entire http request ， it is a generic type
    }
    @GetMapping
    public ResponseEntity getAll(@RequestParam("view") String viewmode)
    {
        Object result = null;
        List<Customer> customers= customerService.getAll();
        List<CustomerListViewDto> result_l = new ArrayList<>();
       // customers.stream().filter()
        if (viewmode.equals("card")){
            result = CustomerMapper.toCardViewDto(customers);
            return ResponseEntity.ok(result);
        }
        if (viewmode.equals("list")){
            for (Customer c:customers){
                CustomerListViewDto LDto = CustomerMapper.toCustomerListViewDto(c, orderService.getOrdersByCustomerId(c.getId()));
                result_l.add(LDto);
            }
            return ResponseEntity.ok(result_l);
        }
        else {
            result = customers;
        }
        return null;
    }


    @GetMapping("/{id}")
    //add @pathVariable when use the parameter id
    public ResponseEntity getById(@PathVariable long id){
       try {
           return ResponseEntity.ok(customerService.getById(id).get());
           //get() used in the type: optional
       } catch (Exception ex) {
           return ResponseEntity.notFound().build();
       }
    }

}
