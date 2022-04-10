package com.example.cinemabackend.dao;

import com.example.cinemabackend.model.Schedule;
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
public class ScheduleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertSchedule(String date, String time) {
        String query = "Insert INTO schedule(date,time)VALUES(?,?)";

        int result = jdbcTemplate.update(query,date,time);

        if(result > 0) {
            System.out.println(result + "schedule added to database");
        }
    }

    public List<Schedule> getSchedulesByMovie(int movieId){
        String query = "SELECT * FROM schedule WHERE movie_id =?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query, movieId);
        List<Schedule> output = new ArrayList<>();
        while(rowSet.next()){
            output.add(new Schedule(rowSet.getInt("schedule_id"),
                    rowSet.getString("date"),
                    rowSet.getString("time"),
                    rowSet.getInt("movie_id"),
                    rowSet.getInt("salon_id")));
        }
        return output;
    }

    public Schedule getScheduleById(int schedule_id) {
        String query = "SELECT * FROM schedule WHERE schedule_id =?";
        Schedule schedule = jdbcTemplate.queryForObject(query,new ScheduleMapper(), schedule_id);
        return schedule;
    }
    private class ScheduleMapper implements RowMapper<Schedule> {

        @Override
        public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
            Schedule sch = new Schedule(rs.getInt("schedule_id"),
                    rs.getString("date"),
                    rs.getString("time"),
                    rs.getInt("movie_id"),
                    rs.getInt("salon_id"));
            return sch;
        }
    }
}