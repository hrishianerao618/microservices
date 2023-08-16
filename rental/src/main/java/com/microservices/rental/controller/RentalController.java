package com.microservices.rental.controller;

import com.microservices.rental.dto.RentalDTO;
import com.microservices.rental.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
