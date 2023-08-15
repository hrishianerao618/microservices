package com.microservices.movie.service;

import com.microservices.movie.dto.FilmDTO;

import java.util.List;

public interface MovieService {
    public List<FilmDTO> getAllFilms();
}
