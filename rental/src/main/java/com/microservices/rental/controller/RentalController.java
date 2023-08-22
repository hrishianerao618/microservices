package com.microservices.rental.controller;

import com.microservices.rental.dto.RentalDTO;
import com.microservices.rental.dto.RentalRequestDTO;
import com.microservices.rental.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/microservice/rental")
public class RentalController {

    @Autowired
    RentalService rentalService;
    @GetMapping(path = "/getAll")
    public List<RentalDTO> getAllRentals(){
        return rentalService.getAllRentals();
    }

    @GetMapping(path = "/getAllRentalByCustomer/{customerId}")
    public List<RentalDTO> findByCustomerId(@PathVariable Long customerId){
        return  rentalService.findByCustomerId(customerId);
    }

    @PostMapping
    public ResponseEntity<RentalDTO> createRental(@RequestBody RentalRequestDTO rentalDTO) {
        RentalDTO createdRental = rentalService.createRental(rentalDTO);
        return new ResponseEntity<>(createdRental, HttpStatus.CREATED);
    }
}
