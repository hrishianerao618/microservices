package com.microservices.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FilmDTO {
    private Integer filmId;
    private String title;
    private String description;
    private String releaseYear;
    private LanguageDTO language; // Assuming you have a LanguageDTO class for the associated entity
    private Short rentalDuration;
    private BigDecimal rentalRate;
    private Short length;
    private BigDecimal replacementCost;
    private String rating;
    private Timestamp lastUpdate;
    private String specialFeatures;
    private String fulltext;
}
