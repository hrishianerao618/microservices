package com.microservices.customer.service;

import com.microservices.customer.dto.CustomerDTO;
import com.microservices.customer.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    public List<CustomerDTO> getAllCustomers();
}
