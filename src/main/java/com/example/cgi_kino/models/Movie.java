package com.example.cgi_kino.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String language;
    private String ageRating;
    private boolean taken;


    /*@ElementCollection
    @CollectionTable(name = "genres")
    private List<String> genre;

    @ElementCollection
    @CollectionTable(name = "subtitles")
    private List<String> subtitles;*/


}