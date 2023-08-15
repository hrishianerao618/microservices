package com.microservices.movie.service.impl;

import com.microservices.movie.dto.FilmDTO;
import com.microservices.movie.dto.LanguageDTO;
import com.microservices.movie.entity.Film;
import com.microservices.movie.repository.MovieRepository;
import com.microservices.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository movieRepository;
    @Override
    public List<FilmDTO> getAllFilms() {
        return movieRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private FilmDTO convertToDTO(Film film){
        FilmDTO filmDTO = new FilmDTO();
        LanguageDTO languageDTO = new LanguageDTO();
        filmDTO.setDescription(film.getDescription());
        filmDTO.setFulltext(film.getFulltext());
        filmDTO.setFilmId(film.getFilmId());
        filmDTO.setLength(film.getLength());
        filmDTO.setRating(film.getRating());

        languageDTO.setLanguageId(film.getLanguage().getLanguageId());
        languageDTO.setName(film.getLanguage().getName());
        languageDTO.setLastUpdate(film.getLanguage().getLastUpdate());

        filmDTO.setLanguage(languageDTO);
        filmDTO.setTitle(film.getTitle());
        filmDTO.setLastUpdate(film.getLastUpdate());
        filmDTO.setReleaseYear(film.getReleaseYear());
        filmDTO.setRentalRate(film.getRentalRate());
        filmDTO.setRentalDuration(film.getRentalDuration());
        filmDTO.setRating(film.getRating());
        filmDTO.setReplacementCost(film.getReplacementCost());
        return filmDTO;
    }
}
