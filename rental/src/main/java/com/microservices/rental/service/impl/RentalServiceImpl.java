package com.microservices.rental.service.impl;

import com.microservices.rental.dto.InventoryDTO;
import com.microservices.rental.dto.RentalDTO;
import com.microservices.rental.dto.RentalRequestDTO;
import com.microservices.rental.dto.StaffDTO;
import com.microservices.rental.entity.Inventory;
import com.microservices.rental.entity.Rental;
import com.microservices.rental.entity.Staff;
import com.microservices.rental.repository.InventoryRepository;
import com.microservices.rental.repository.RentalRepository;
import com.microservices.rental.repository.StaffRepository;
import com.microservices.rental.service.RentalService;
import com.microservices.rental.event.RentalEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RentalServiceImpl implements RentalService {
    @Autowired
    RentalRepository rentalRepository;

    @Autowired
    InventoryRepository inventoryRepository;

    @Autowired
    private KafkaTemplate<String, RentalEvent> kafkaTemplate;

    @Autowired
    StaffRepository staffRepository;
    @Override
    public List<RentalDTO> getAllRentals() {
        return rentalRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<RentalDTO> findByCustomerId(Long customerId) {

            return rentalRepository.findByCustomerId(customerId).stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());

    }

    @Override
    public RentalDTO createRental(RentalRequestDTO rentalDTO) {
        Rental rental = new Rental();

        Inventory inventory = inventoryRepository.findById(1).get();
        log.info("Inventory {}",inventory.getInventoryId());
        rental.setInventory(inventory);

        log.info("Rental {}",rental.getInventory().getInventoryId());

        Staff staff = staffRepository.findById(1).get();
        rental.setStaff(staff);

        rental.setRentalDate(LocalDateTime.now()); // Set rental date to the current time
        rental.setCustomerId(rentalDTO.getCustomerId());
        rental.setReturnDate(LocalDateTime.now());
        rental.setLastUpdate(LocalDateTime.now());

        rental = rentalRepository.save(rental);

        kafkaTemplate.send("rentalSaveTopic",  new RentalEvent(rental.getRentalId()));
        return convertToDTO(rental);
    }

    private RentalDTO convertToDTO(Rental rental) {
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

    private InventoryDTO convertToInventoryDTO(Inventory inventory) {
        InventoryDTO inventoryDTO = new InventoryDTO();
        inventoryDTO.setInventoryId(inventory.getInventoryId());
        inventoryDTO.setStoreId(inventory.getStoreId());
        inventoryDTO.setFilmId(inventory.getFilmId());
        inventoryDTO.setLastUpdate(inventory.getLastUpdate());
        return inventoryDTO;
    }

    private StaffDTO convertToStaffDTO(Staff staff) {
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
