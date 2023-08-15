package com.microservices.customer.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
public class CountryDTO {

    private Integer countryId;
    private String country;
    private Timestamp lastUpdate;
}
