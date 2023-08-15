package com.microservices.customer.service.impl;

import com.microservices.customer.dto.CustomerDTO;
import com.microservices.customer.entity.Customer;
import com.microservices.customer.repository.CustomerRepository;
import com.microservices.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream().
                map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private CustomerDTO convertToDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerId(customer.getCustomerId());
        customerDTO.setActive(customer.getActive());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setActivebool(customer.getActivebool());
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setStoreId(customer.getStoreId());

        return customerDTO;
    }
}
