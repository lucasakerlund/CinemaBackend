package com.example.cinemabackend.api;

import com.example.cinemabackend.model.Genre;
import com.example.cinemabackend.service.GenreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RequestMapping("api/v1/genre")
@RestController
public class GenreController {

    private final GenreService service;

    public GenreController(GenreService service){
        this.service = service;
    }

    @GetMapping(path = "{id}")
    public String getGenreById(@PathVariable("id") int genreId){
        return service.getGenreById(genreId);
    }

    @GetMapping
    public HashMap<Integer, String> getGenres(){
        return service.getGenres();
    }

}
