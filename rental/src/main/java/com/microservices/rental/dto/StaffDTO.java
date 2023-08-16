package com.microservices.rental.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class StaffDTO {

    private Integer staffId;
    private String firstName;
    private String lastName;
    private Long address;
    private String email;
    private Integer storeId;
    private Boolean active;
    private String username;
    private String password;
    private LocalDateTime lastUpdate;
    private byte[] picture;
}
