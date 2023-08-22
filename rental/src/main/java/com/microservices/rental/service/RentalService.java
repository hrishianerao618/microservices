package com.microservices.rental.service;

import com.microservices.rental.dto.RentalDTO;
import com.microservices.rental.dto.RentalRequestDTO;

import java.util.List;

public interface RentalService {

    public List<RentalDTO> getAllRentals();

    public List<RentalDTO> findByCustomerId(Long customerId);

    RentalDTO createRental(RentalRequestDTO rentalDTO);
}
