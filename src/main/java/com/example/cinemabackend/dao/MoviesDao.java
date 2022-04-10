package com.example.cinemabackend.dao;

import com.example.cinemabackend.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MoviesDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertMovies(String title, String description, int ageRestriction, String categoryCoverImage, String coverImage){
        String query ="Insert INTO movies(title, description, age_restriction, category_cover_image, cover_image) VALUES(?,?,?,?,?)";

        int result = jdbcTemplate.update(query,title, description, ageRestriction, categoryCoverImage, coverImage);

        if(result > 0){
            System.out.println(result + "movies added to database");

        }
    }

    public Movie[] getMovies(){
        String query = "SELECT * FROM movies";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query);
        List<Movie> output = new ArrayList<>();
        while(rowSet.next()){
            output.add(new Movie(rowSet.getInt("movie_id"),
                    rowSet.getString("title"),
                    rowSet.getString("description"),
                    rowSet.getInt("age_restriction"),
                    rowSet.getString("category_cover_image"),
                    rowSet.getString("cover_image")));
        }
        return output.toArray(new Movie[0]);
    }

    public Movie getMovieById(int movie_id){
        String query = "SELECT * FROM movies WHERE movie_id=?";
        Movie movies = jdbcTemplate.queryForObject(query,new MoviesMapper(), movie_id);
        return movies;
    }
    private class MoviesMapper implements RowMapper<Movie> {

        @Override
        public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
            Movie mov = new Movie(rs.getInt("movie_id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getInt("age_restriction"),
                    rs.getString("category_cover_image"),
                    rs.getString("cover_image"));
            return mov;
        }

    }
}
