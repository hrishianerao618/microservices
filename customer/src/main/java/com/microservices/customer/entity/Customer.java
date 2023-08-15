package com.microservices.customer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;

    @Column(nullable = false)
    private Long storeId;

    @Column(nullable = false,  length = 45 )
    private String firstName;

    @Column(nullable = false,  length = 45 )
    private String lastName;

    @Column(nullable = false, length = 50)
    private String email;

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id", insertable = false, updatable = false)
    private Address address;

    @Column(nullable = false, columnDefinition = "boolean default true")
    private Boolean activebool;

    @Column(nullable = false, columnDefinition = "DATE DEFAULT current_date")
    private Date createDate;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT current_timestamp")
    private Timestamp lastUpdate;

    @Column(nullable = false)
    private Long active;

}
