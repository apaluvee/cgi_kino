package com.example.cgi_kino.services;

import com.example.cgi_kino.dto.MovieDto;

import java.util.List;

public interface MovieService {

    MovieDto addMovie(MovieDto movieDto);

    MovieDto getMovie(Long id);

    List<MovieDto> getAllMovies();

    MovieDto updateMovie(MovieDto movieDto, Long id);

    void deleteMovie(Long id);

    //MovieDto takeSeat(Long id);

}
