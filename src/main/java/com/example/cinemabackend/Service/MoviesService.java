package com.example.cinemabackend.Service;

import com.example.cinemabackend.dao.MoviesDao;
import com.example.cinemabackend.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MoviesService {
    @Autowired
    MoviesDao moviesDao;
    public void InsertMovies(Movie movies) {
        moviesDao.insertMovies(movies.getName());
    }
    public Movie getMoviesById(String movie_id){
        Movie movies = moviesDao.getMoviesById(movie_id);
        return movies;
    }
}
