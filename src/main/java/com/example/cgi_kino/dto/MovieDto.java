package com.example.cgi_kino.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
    private int id;
    private String title;
    private String language;
    private int ageRating;
    private boolean taken;

}
