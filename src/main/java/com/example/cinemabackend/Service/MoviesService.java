package com.example.cinemabackend.service;

import com.example.cinemabackend.dao.MoviesDao;
import com.example.cinemabackend.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MoviesService {

    @Autowired
    MoviesDao moviesDao;

    public void InsertMovies(String title, String description, int ageRestriction, String categoryCoverImage, String coverImage) {
        moviesDao.insertMovies(title, description, ageRestriction, categoryCoverImage, coverImage);
    }

    public Movie[] getMovies(){
        return moviesDao.getMovies();
    }

    public Movie getMoviesById(int movie_id){
        Movie movies = moviesDao.getMovieById(movie_id);
        return movies;
    }
}
