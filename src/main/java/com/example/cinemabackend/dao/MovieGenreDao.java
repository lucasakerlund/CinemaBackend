package com.example.cinemabackend.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("movieGenre")
public class MovieGenreDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int[] getGenreIdsByMovieId(int movieId){
        String query = "SELECT * FROM movie_genres WHERE movie_id =?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query, movieId);
        List<Integer> output = new ArrayList<>();
        while(rowSet.next()){
            output.add(rowSet.getInt("genre_id"));
        }
        return output.stream().mapToInt(i->i).toArray();
    }

}
