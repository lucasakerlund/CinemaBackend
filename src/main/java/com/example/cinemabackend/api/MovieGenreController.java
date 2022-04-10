package com.example.cinemabackend.api;

import com.example.cinemabackend.service.MovieGenreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/movie_genre")
@RestController
public class MovieGenreController {

    private final MovieGenreService service;

    public MovieGenreController(MovieGenreService service){
        this.service = service;
    }

    @GetMapping(path = "{id}")
    public int[] getGenreIdsByMovieId(@PathVariable("id") int movieId){
        return service.getGenreIdsByMovieId(movieId);
    }

}
