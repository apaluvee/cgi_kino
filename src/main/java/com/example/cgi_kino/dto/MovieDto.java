package com.example.cgi_kino.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
    private int id;
    private String title;
    private String genre;
    private String ageRating;
    private LocalDateTime startTime;
    private String language;

}
