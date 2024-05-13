package com.parit.bms.controllers;

import com.parit.bms.dtos.CreateMovieDto;
import com.parit.bms.models.Movie;
import com.parit.bms.services.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
@AllArgsConstructor
public class MovieController {

    private MovieService movieService;

    @PostMapping
    public Movie createMovie(@RequestBody CreateMovieDto movie) {

        return movieService.createMovie(movie.toMovie());

    }

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable("id") Long id) {
        return movieService.getMovie(id);

    }





}
