package com.example.cinemabackend.Service;

import com.example.cinemabackend.dao.MoviesDao;
import com.example.cinemabackend.model.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MoviesService {
    @Autowired
    MoviesDao moviesDao;
    public void InsertMovies(Movies movies) {
        moviesDao.insertMovies(movies.getName());
    }
    public Movies getMoviesById(String movie_id){
        Movies movies = moviesDao.getMoviesById(movie_id);
        return movies;
    }
}
