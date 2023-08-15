package com.microservices.customer.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
        private Long addressId;
        private String address;
        private String address2;
        private String district;
        private String city;
        private String postalCode;
        private String phone;
        private CountryDTO country;

        // Constructors, getters, setters...

}
