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
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "country_sequence")
    @SequenceGenerator(name = "country_sequence", sequenceName = "country_country_id_seq", allocationSize = 1)
    @Column(name = "country_id")
    private Integer countryId;

    @Column(name = "country", nullable = false, length = 50)
    private String country;

    @Column(name = "last_update", nullable = false)
    private Timestamp lastUpdate;

}
