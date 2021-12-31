package com.example.movieandactorexample;

import com.example.movieandactorexample.model.Actor;
import com.example.movieandactorexample.model.Movie;
import com.example.movieandactorexample.repository.ActorRepository;
import com.example.movieandactorexample.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class MovieRepositoryAndActorExampleApplicationTests {

    private final ActorRepository actorRepository;
    private final MovieRepository movieRepository;

    @Autowired
    public MovieRepositoryAndActorExampleApplicationTests(ActorRepository actorRepository, MovieRepository movieRepository) {
        this.actorRepository = actorRepository;
        this.movieRepository = movieRepository;
    }

    @Test
    void contextLoads() {

        Movie movie = new Movie();
        movie.setId(1L);
        movie.setMovieName("movie");
        movie.setScore(9.9);
        movie.setDate(new Date());

        Movie movie2 = new Movie();
        movie2.setId(2L);
        movie2.setMovieName("movie2");
        movie2.setScore(6.5);
        movie2.setDate(new Date());


        Actor actor = new Actor();
        actor.setId(1L);
        actor.setActorName("actor");


        ArrayList<Movie> movieArrayList = new ArrayList<Movie>();
        movieArrayList.add(movie);
        movieArrayList.add(movie2);

        ArrayList<Actor> actorArrayList = new ArrayList<Actor>();
        actorArrayList.add(actor);

        actor.setMovies(movieArrayList);
        movie.setActors(actorArrayList);
        movie2.setActors(actorArrayList);

        //actorRepository.save(actor);
        movieRepository.save(movie);
        movieRepository.save(movie2);
    }

}
