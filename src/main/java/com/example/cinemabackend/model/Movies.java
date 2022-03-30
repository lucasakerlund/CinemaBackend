package com.example.cinemabackend.model;

public class Movies {
    private int movieId;
    private String name;
    private int ageRestriction;

    public Movies (int movieId, String name, int ageRestriction) {
        this.movieId = movieId;
        this.name = name;
        this.ageRestriction = ageRestriction;
    }

    public int getMovieId() {return movieId;}

    public void setMovieId(int movieId) {this.movieId = movieId;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public int getAgeRestriction() {return ageRestriction;}

    public void setAgeRestriction(int ageRestriction) {this.ageRestriction = ageRestriction;}

    @Override
    public String toString() {
        return "Movies{" +
                "movieId=" + movieId +
                ", name='" + name + '\'' +
                ", ageRestriction=" + ageRestriction +
                '}';
    }
}
