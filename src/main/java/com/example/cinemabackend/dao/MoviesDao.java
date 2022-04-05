package com.example.cinemabackend.dao;

import com.example.cinemabackend.model.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class MoviesDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertMovies(String name){
        String query ="Insert INTO movies(name)VALUES(?)";

        int result = jdbcTemplate.update(query,name);

        if(result > 0){
            System.out.println(result + "movies added to database");

        }
    }
    public Movies getMoviesById(String movie_id){
        String query = "SELECT * FROM movies WHERE movie_id=?";
        Movies movies = jdbcTemplate.queryForObject(query,new MoviesMapper());
        return movies;
    }
    private class MoviesMapper implements RowMapper<Movies> {


        @Override
        public Movies mapRow(ResultSet rs, int rowNum) throws SQLException {
            Movies mov = new Movies(rs.getInt("movie_id"),
                    rs.getString("name"),0); //fix ageRestriction later
            return mov;
        }

    }
}
