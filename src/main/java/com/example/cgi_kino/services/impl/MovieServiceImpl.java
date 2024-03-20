package com.example.cgi_kino.services.impl;

import com.example.cgi_kino.dto.MovieDto;
import com.example.cgi_kino.models.Movie;
import com.example.cgi_kino.repositories.MovieRepository;
import com.example.cgi_kino.services.MovieService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    private ModelMapper modelMapper;

    @Override
    public MovieDto addMovie(MovieDto movieDto) {
        Movie movie = modelMapper.map(movieDto, Movie.class);

        Movie savedMovie = movieRepository.save(movie);

        return modelMapper.map(savedMovie, MovieDto.class);
    }

    @Override
    public MovieDto getMovie(Long id) {

        Movie movie = movieRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("Not found: " + id));

        return modelMapper.map(movie, MovieDto.class);
    }

    @Override
    public List<MovieDto> getAllMovies() {

        List<Movie> movies = movieRepository.findAll();

        return movies.stream().map((movie) -> modelMapper.map(movie, MovieDto.class)).collect(Collectors.toList());
    }

    @Override
    public MovieDto updateMovie(MovieDto movieDto, Long id) {
        Movie movie = movieRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("Not found: " + id));

        movie.setTitle(movieDto.getTitle());
        movie.setLanguage(movieDto.getLanguage());
        movie.setAgeRating(String.valueOf(movieDto.getAgeRating()));

        Movie updatedMovie = movieRepository.save(movie);

        return modelMapper.map(updatedMovie, MovieDto.class);
    }

    @Override
    public void deleteMovie(Long id) {

        Movie movie = movieRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("Not found: " + id));

        movieRepository.deleteById(Math.toIntExact(id));
    }

}