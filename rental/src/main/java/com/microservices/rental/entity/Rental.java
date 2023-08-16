package com.microservices.rental.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "rental")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rental_sequence")
    @SequenceGenerator(name = "rental_sequence", sequenceName = "rental_rental_id_seq", allocationSize = 1)
    @Column(name = "rental_id")
    private Integer rentalId;

    @Column(name = "rental_date", nullable = false)
    private LocalDateTime rentalDate;

    @ManyToOne
    @JoinColumn(name = "inventory_id", referencedColumnName = "inventory_id", insertable = false, updatable = false)
    private Inventory inventory;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;//for microservice architecture we are not using references instead only key. Since customer is in different microservice. We can make an api call if we need customer details of this ID

    @Column(name = "return_date")
    private LocalDateTime returnDate;

    @ManyToOne
    @JoinColumn(name = "staff_id", referencedColumnName = "staff_id", insertable = false, updatable = false)
    private Staff staff;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;

}
