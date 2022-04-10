package com.example.cinemabackend.api;

import com.example.cinemabackend.model.Movie;
import com.example.cinemabackend.service.MoviesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/movies")
@RestController
public class MoviesController {

    private MoviesService service;

    public MoviesController(MoviesService service){
        this.service = service;
    }

    @GetMapping("{id}")
    public Movie getMovieById(@PathVariable("id") int movieId){
        return service.getMoviesById(movieId);
    }

    @GetMapping
    public Movie[] getMovies(){
        return service.getMovies();
    }

}
