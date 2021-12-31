package com.example.movieandactorexample.business.service;

import com.example.movieandactorexample.dto.MovieDto;
import com.example.movieandactorexample.model.Movie;

import java.util.List;

public interface MovieService {

    List<MovieDto> getAllMoviesWithDetails();

    Movie add(Movie movie);
}
