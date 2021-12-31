package com.example.movieandactorexample.repository;

import com.example.movieandactorexample.dto.ActorDto;
import com.example.movieandactorexample.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Long> {

    @Query("select new com.example.movieandactorexample.dto.ActorDto" +
            "(a.id, a.actorName, m.movieName)" +
            " from Actor a" +
            " inner join a.movies m")
    List<ActorDto> getAllActorsWithDetails();
}
