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
public class InventoryDTO {
    private Integer inventoryId;
    private Long filmId;
    private Integer storeId;
    private LocalDateTime lastUpdate;
}
