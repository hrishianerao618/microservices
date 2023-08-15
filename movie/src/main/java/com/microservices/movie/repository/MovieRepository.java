package com.microservices.movie.repository;

import com.microservices.movie.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Film, Integer> {
}
