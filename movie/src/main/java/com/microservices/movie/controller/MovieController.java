package com.microservices.movie.controller;

import com.microservices.movie.dto.FilmDTO;
import com.microservices.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/microservice/movie")
public class MovieController {
@Autowired
    MovieService movieService;
@GetMapping(path = "/getAll")
    List<FilmDTO> getAllFilms(){
    return movieService.getAllFilms();
    }
}
