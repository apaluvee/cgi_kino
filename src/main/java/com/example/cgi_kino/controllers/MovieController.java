package com.example.cgi_kino.controllers;

import com.example.cgi_kino.dto.MovieDto;
import com.example.cgi_kino.services.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@AllArgsConstructor
public class MovieController {

    private MovieService movieService;

    @PostMapping
    public ResponseEntity<MovieDto> addMovie(@RequestBody MovieDto movieDto) {

        MovieDto savedMovie = movieService.addMovie(movieDto);

        return new ResponseEntity<>(savedMovie, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<MovieDto> getMovie(@PathVariable("id") Long movieId){
        MovieDto movieDto = movieService.getMovie(movieId);
        return new ResponseEntity<>(movieDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> getAllMovies() {
        List<MovieDto> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    @PostMapping("{id}")
    public ResponseEntity<MovieDto> updateMovie(@RequestBody MovieDto movieDto,@PathVariable("id") Long movieId){
        MovieDto updatedMovie = movieService.updateMovie(movieDto, movieId);
        return ResponseEntity.ok(updatedMovie);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable("id") Long movieId) {
        movieService.deleteMovie(movieId);
        return ResponseEntity.ok("Movie deleted!");
    }

}
