package com.example.cinemabackend.dao;

import com.example.cinemabackend.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository("genre")
public class GenreDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String getGenreById(int genreId){
        String query = "SELECT * FROM genres WHERE genre_id =?";
        return jdbcTemplate.queryForRowSet(query, genreId).getString("genre");
    }

    public HashMap<Integer, String> getGenres(){
        String query = "SELECT * FROM genres";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query);
        HashMap<Integer, String> output = new HashMap();
        while(rowSet.next()){
            output.put(rowSet.getInt("genre_id"), rowSet.getString("genre"));
        }
        return output;
    }

}
