package com.microservices.customer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_sequence")
    @SequenceGenerator(name = "address_sequence", sequenceName = "address_address_id_seq", allocationSize = 1)
   @Column(name = "address_id")
    private Long addressId;

    @Column(name = "address", length = 50, nullable = false)
    private String address;

    @Column(name = "address2", length = 50)
    private String address2;

    @Column(name = "district", length = 20, nullable = false)
    private String district;

    @Column(name = "city_id", nullable = false)
    private Short cityId;

    @Column(name = "postal_code", length = 10)
    private String postalCode;

    @Column(name = "phone", length = 20, nullable = false)
    private String phone;

    @Column(name = "last_update", nullable = false)
    private Timestamp lastUpdate;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "city_id", insertable = false, updatable = false)
    private City city;
}



