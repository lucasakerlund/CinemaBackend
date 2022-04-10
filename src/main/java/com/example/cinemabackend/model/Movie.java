package com.example.cinemabackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {
    private int movieId;
    private String title;
    private String description;
    private int ageRestriction;
    private String categoryCoverImage;
    private String coverImage;

    public Movie(@JsonProperty("movie_id") int movieId,
                 @JsonProperty("title") String title,
                 @JsonProperty("description") String description,
                 @JsonProperty("age_restriction") int ageRestriction,
                 @JsonProperty("category_cover_image") String categoryCoverImage,
                 @JsonProperty("cover_image") String coverImage) {
        this.movieId = movieId;
        this.title = title;
        this.description = description;
        this.ageRestriction = ageRestriction;
        this.categoryCoverImage = categoryCoverImage;
        this.coverImage = coverImage;
    }

    public int getMovieId() {return movieId;}

    public void setMovieId(int movieId) {this.movieId = movieId;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAgeRestriction() {return ageRestriction;}

    public void setAgeRestriction(int ageRestriction) {this.ageRestriction = ageRestriction;}

    public String getCategoryCoverImage() {
        return categoryCoverImage;
    }

    public void setCategoryCoverImage(String categoryCoverImage) {
        this.categoryCoverImage = categoryCoverImage;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "movieId=" + movieId +
                ", name='" + title + '\'' +
                ", ageRestriction=" + ageRestriction +
                '}';
    }
}
