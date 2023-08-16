package com.microservices.customer.service.impl;

import com.microservices.customer.config.WebClientConfig;
import com.microservices.customer.dto.CustomerDTO;
import com.microservices.customer.dto.RentalDTO;
import com.microservices.customer.entity.Customer;
import com.microservices.customer.repository.CustomerRepository;
import com.microservices.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    WebClient webClient;
    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream().
                map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<RentalDTO> getRentalsForCustomer(Long customerId) {
        Optional<CustomerDTO> optCustomerDTO = customerRepository.findById(customerId).
               map(this::convertToDTO);
        CustomerDTO customerDTO = optCustomerDTO.orElse(new CustomerDTO());

        List<RentalDTO> rentalDTO = webClient.get().uri("http://localhost:8083/api/microservice/rental/getAllRentalByCustomer/"+customerId)
                .retrieve()
                .bodyToFlux(RentalDTO.class)
                .map(tempRentalDTO -> {
                    RentalDTO finalRentalDTO = tempRentalDTO;
                    finalRentalDTO.setEmail(customerDTO.getEmail());
                    finalRentalDTO.setFirstName(customerDTO.getFirstName());
                    return finalRentalDTO;
                })
                .collectList()
                .block();

        return rentalDTO;

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
