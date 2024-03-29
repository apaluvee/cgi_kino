package com.example.cgi_kino.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String genre;
    private String ageRating;
    private LocalDateTime startTime;
    private String language;



    /*@ElementCollection
    @CollectionTable(name = "genres")
    private List<String> genre;

    @ElementCollection
    @CollectionTable(name = "subtitles")
    private List<String> subtitles;*/


}