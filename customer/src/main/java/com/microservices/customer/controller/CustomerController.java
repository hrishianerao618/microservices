package com.microservices.customer.controller;

import com.microservices.customer.dto.CustomerDTO;
import com.microservices.customer.dto.RentalDTO;
import com.microservices.customer.service.CustomerService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/microservice/customer")
@Slf4j
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @GetMapping(path = "/getAll")
    public List<CustomerDTO> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping(path = "/getAllRentalsByCustomer/{customerId}")
    @CircuitBreaker(name = "rental", fallbackMethod = "rentalCallFailed")
    @TimeLimiter(name = "rental")
    @Retry(name = "rental")
    public CompletableFuture<List<RentalDTO>> getAllRentalsByCustomer(@PathVariable Long customerId){
       return  CompletableFuture.supplyAsync(()->customerService.getRentalsForCustomer(customerId));
    }

    public CompletableFuture<List<RentalDTO>> rentalCallFailed( Long customerId , RuntimeException exception){
        log.error("rentalCallFailed::{}", exception);
        return CompletableFuture.supplyAsync(()->new ArrayList<>());
    }

    public CompletableFuture<List<RentalDTO>> rentalCallFailedTimer( Long customerId , RuntimeException exception){
        log.error("rentalCallFailed::{}", exception);
        return CompletableFuture.completedFuture(new ArrayList<>());
    }

}
