package com.example.cinemabackend.service;

import com.example.cinemabackend.dao.MovieGenreDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MovieGenreService {

    private final MovieGenreDao dao;

    public MovieGenreService(@Qualifier("movieGenre") MovieGenreDao dao){
        this.dao = dao;
    }

    public int[] getGenreIdsByMovieId(int movieId){
        return dao.getGenreIdsByMovieId(movieId);
    }

}
