package com.example.movieandactorexample.repository;

import com.example.movieandactorexample.dto.MovieDto;
import com.example.movieandactorexample.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("select new com.example.movieandactorexample.dto.MovieDto" +
            "(m.id, m.movieName, m.score, m.date, a.actorName)" +
            " from Movie m" +
            " inner join m.actors a")
    List<MovieDto> getAllMoviesWithDetails();
}
