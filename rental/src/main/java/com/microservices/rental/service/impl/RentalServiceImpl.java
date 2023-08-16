package com.microservices.rental.service.impl;

import com.microservices.rental.dto.InventoryDTO;
import com.microservices.rental.dto.RentalDTO;
import com.microservices.rental.dto.StaffDTO;
import com.microservices.rental.entity.Inventory;
import com.microservices.rental.entity.Rental;
import com.microservices.rental.entity.Staff;
import com.microservices.rental.repository.RentalRepository;
import com.microservices.rental.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalServiceImpl implements RentalService {
    @Autowired
    RentalRepository rentalRepository ;
    @Override
    public List<RentalDTO> getAllRentals() {
        return rentalRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private RentalDTO convertToDTO(Rental rental){
        RentalDTO rentalDTO = new RentalDTO();

        rentalDTO.setRentalId(rental.getRentalId());
        rentalDTO.setRentalDate(rental.getRentalDate());
        rentalDTO.setCustomerId(rental.getCustomerId());

        rentalDTO.setInventory(convertToInventoryDTO(rental.getInventory()));
        rentalDTO.setStaff(convertToStaffDTO(rental.getStaff()));

        rentalDTO.setLastUpdate(rental.getLastUpdate());
        rentalDTO.setReturnDate(rental.getReturnDate());

        return rentalDTO;
    }

    private InventoryDTO convertToInventoryDTO(Inventory inventory){
        InventoryDTO inventoryDTO = new InventoryDTO();
        inventoryDTO.setInventoryId(inventory.getInventoryId());
        inventoryDTO.setStoreId(inventory.getStoreId());
        inventoryDTO.setFilmId(inventory.getFilmId());
        inventoryDTO.setLastUpdate(inventory.getLastUpdate());
        return inventoryDTO;
    }
    private StaffDTO convertToStaffDTO(Staff staff){
        StaffDTO staffDTO = new StaffDTO();
        staffDTO.setStaffId(staff.getStaffId());
        staffDTO.setActive(staff.getActive());
        staffDTO.setAddress(staff.getAddressId());
        staffDTO.setPassword(staff.getPassword());
        staffDTO.setFirstName(staff.getFirstName());
        staffDTO.setPicture(staff.getPicture());
        staffDTO.setEmail(staff.getEmail());
        staffDTO.setUsername(staff.getUsername());
        staffDTO.setStoreId(staff.getStoreId());
        staffDTO.setLastName(staff.getLastName());
        staffDTO.setLastUpdate(staff.getLastUpdate());
        return staffDTO;

    }
}