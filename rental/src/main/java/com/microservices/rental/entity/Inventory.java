package com.microservices.rental.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;

@Entity
@Table(name = "inventory")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inventory_sequence")
    @SequenceGenerator(name = "inventory_sequence", sequenceName = "inventory_inventory_id_seq", allocationSize = 1)
    @Column(name = "inventory_id")
    private Integer inventoryId;

    @Column(name = "film_id", nullable = false)
    private Long filmId;

    @Column(name = "store_id", nullable = false)
    private Integer storeId;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;
}
