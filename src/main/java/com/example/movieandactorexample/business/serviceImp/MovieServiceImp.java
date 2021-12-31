package com.example.movieandactorexample.business.serviceImp;

import com.example.movieandactorexample.business.service.ActorService;
import com.example.movieandactorexample.business.service.MovieService;
import com.example.movieandactorexample.dto.MovieDto;
import com.example.movieandactorexample.model.Actor;
import com.example.movieandactorexample.model.Movie;
import com.example.movieandactorexample.repository.ActorRepository;
import com.example.movieandactorexample.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Stream;

@Service
public class MovieServiceImp implements MovieService {

    private final MovieRepository movieRepository;
    private final ActorRepository actorRepository;

    @Autowired
    public MovieServiceImp(MovieRepository movieRepository, ActorRepository actorRepository) {
        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository;
    }

    @Override
    public List<MovieDto> getAllMoviesWithDetails() {
        return movieRepository.getAllMoviesWithDetails();
    }

    @Override
    @Transactional
    public Movie add(Movie movie) {
        List<Optional<Actor>> actorList = movie.getActors().stream().filter(actor -> actor.getId() != null)
                .filter(actor -> actorRepository.findById(actor.getId()).isPresent())
                .map(actor -> actorRepository.findById(actor.getId())).toList();
        if (!actorList.isEmpty()) {
            actorList.forEach(actor -> actor.get().setMovies(Stream.concat(
                    actor.get().getMovies().stream(), Stream.of(movie)
            ).toList()));
            List<Actor> actors = actorList.stream().map(actor -> actor.get()).toList();
            movie.setActors(handleActors(movie, actors));
        }
        movieRepository.save(movie);
        return movie;
    }

    private List<Actor> handleActors(Movie movie, List<Actor> actorsToHandle) {
        List<Actor> resultList = movie.getActors().stream().filter(actor -> actor.getId() == null).toList();
        return Stream.concat(resultList.stream(), actorsToHandle.stream()).toList();
    }
}
