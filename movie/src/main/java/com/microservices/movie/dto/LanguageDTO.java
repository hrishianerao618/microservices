package com.microservices.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LanguageDTO {

    private Integer languageId;
    private String name;
    private Timestamp lastUpdate;

}
