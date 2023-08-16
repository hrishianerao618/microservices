package com.microservices.rental.service;

import com.microservices.rental.dto.RentalDTO;

import java.util.List;

public interface RentalService {

    public List<RentalDTO> getAllRentals();
}
