package com.microservices.rental.repository;

import com.microservices.rental.entity.Inventory;
import com.microservices.rental.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
}
