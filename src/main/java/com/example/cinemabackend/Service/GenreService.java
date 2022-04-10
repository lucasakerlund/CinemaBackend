package com.example.cinemabackend.service;

import com.example.cinemabackend.dao.GenreDao;
import com.example.cinemabackend.model.Genre;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class GenreService {

    private final GenreDao dao;

    public GenreService(@Qualifier("genre") GenreDao dao){
        this.dao = dao;
    }

    public String getGenreById(int genreId){
        return dao.getGenreById(genreId);
    }

    public HashMap<Integer, String> getGenres(){
        return dao.getGenres();
    }

}
