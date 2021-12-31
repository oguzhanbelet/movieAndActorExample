package com.example.movieandactorexample.business.service;

import com.example.movieandactorexample.dto.ActorDto;
import com.example.movieandactorexample.model.Actor;

import java.util.List;

public interface ActorService {

    List<ActorDto> getAllActorsWithDetails();

    void add(Actor actor);
}
