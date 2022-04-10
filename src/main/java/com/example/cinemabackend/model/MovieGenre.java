package com.example.cinemabackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieGenre {

    private int movieId;
    private int genreId;

    public MovieGenre(@JsonProperty("movie_id") int movieId,
                      @JsonProperty("genre_id") int genreId) {
        this.movieId = movieId;
        this.genreId = genreId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }
}
