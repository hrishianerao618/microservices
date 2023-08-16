package com.microservices.rental.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RentalDTO {
    private Integer rentalId;
    private LocalDateTime rentalDate;
    private InventoryDTO inventory;
    private Long customerId;
    private LocalDateTime returnDate;
    private StaffDTO staff;
    private LocalDateTime lastUpdate;
}
