package com.microservices.customer.controller;

import com.microservices.customer.dto.CustomerDTO;
import com.microservices.customer.dto.RentalDTO;
import com.microservices.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/microservice/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @GetMapping(path = "/getAll")
    public List<CustomerDTO> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping(path = "/getAllRentalsByCustomer/{customerId}")
    public List<RentalDTO> getAllRentalsByCustomer(@PathVariable Long customerId){
       return  customerService.getRentalsForCustomer(customerId);
    }

}
