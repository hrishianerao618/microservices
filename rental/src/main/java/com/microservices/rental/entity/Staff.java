package com.microservices.rental.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "staff")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Staff {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "staff_sequence")
        @SequenceGenerator(name = "staff_sequence", sequenceName = "staff_staff_id_seq", allocationSize = 1)
        @Column(name = "staff_id")
        private Integer staffId;

        @Column(name = "first_name", nullable = false)
        private String firstName;

        @Column(name = "last_name", nullable = false)
        private String lastName;

        @Column(name = "address_id", nullable = false)
        private Long addressId;

        @Column(name = "email")
        private String email;

        @Column(name = "store_id", nullable = false)
        private Integer storeId;

        @Column(name = "active", nullable = false)
        private Boolean active;

        @Column(name = "username", nullable = false)
        private String username;

        @Column(name = "password")
        private String password;

        @Column(name = "last_update", nullable = false)
        private LocalDateTime lastUpdate;

        @Column(name = "picture")
        private byte[] picture;


}
