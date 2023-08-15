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
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_sequence")
    @SequenceGenerator(name = "city_sequence", sequenceName = "city_city_id_seq", allocationSize = 1)
    @Column(name = "city_id")
    private Integer cityId;

    @Column(name = "city", nullable = false, length = 50)
    private String city;

    @Column(name = "country_id", nullable = false)
    private Short countryId;

    @Column(name = "last_update", nullable = false)
    private Timestamp lastUpdate;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "country_id", insertable = false, updatable = false)
    private Country country;


}
