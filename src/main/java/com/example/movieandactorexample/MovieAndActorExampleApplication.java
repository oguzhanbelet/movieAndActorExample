package com.example.movieandactorexample;

import com.example.movieandactorexample.model.Actor;
import com.example.movieandactorexample.model.Movie;
import com.example.movieandactorexample.repository.ActorRepository;
import com.example.movieandactorexample.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class MovieAndActorExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieAndActorExampleApplication.class, args);

    }


}
