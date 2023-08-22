package com.microservices.rental.repository;

import com.microservices.rental.entity.Inventory;
import com.microservices.rental.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {
}
