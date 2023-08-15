package com.microservices.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CustomerDTO {

    private Long customerId;
    private Long storeId;
    private String firstName;
    private String lastName;
    private String email;
    //private AddressDTO address;
    private Boolean activebool;
    private Date createDate;
    private Timestamp lastUpdate;
    private Long active;
}
