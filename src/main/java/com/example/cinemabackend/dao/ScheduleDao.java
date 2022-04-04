package com.example.cinemabackend.dao;

import com.example.cinemabackend.model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

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
    public Schedule getScheduleById(String movie_id) {
        String query = "SELECT * FROM schedule WHERE movie_id =?";
        Schedule schedule = jdbcTemplate.queryForObject(query,new ScheduleMapper());
        return schedule;
    }
    private class ScheduleMapper implements RowMapper<Schedule> {

        @Override
        public Schedule mapRow(Resultset rs, int rowNum) throws SQLException {
            Schedule sch = new Schedule(rs.getInt(movie_id),
                    rs.getString(date),
                    rs.getString(time));
            return sch;
        }
    }
}
