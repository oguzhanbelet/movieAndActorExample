package com.example.movieandactorexample.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String movieName;

    private double score;

    private Date date;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Actor> actors;

}
