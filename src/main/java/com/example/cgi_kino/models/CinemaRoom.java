package com.example.cgi_kino.models;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class CinemaRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

}
