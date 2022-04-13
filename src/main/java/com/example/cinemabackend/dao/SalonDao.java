package com.example.cinemabackend.dao;

import com.example.cinemabackend.model.Salon;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("salons")
public class SalonDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Salon> getSalons(){
        String query = "SELECT * FROM salons";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query);
        List<Salon> output = new ArrayList<>();
        while(rowSet.next()){
            output.add(new Salon(rowSet.getInt("salon_id")));
        }
        return output;
    }

}
