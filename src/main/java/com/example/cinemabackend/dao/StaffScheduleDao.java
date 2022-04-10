package com.example.cinemabackend.dao;

import com.example.cinemabackend.model.Staff;
import com.example.cinemabackend.model.StaffSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class StaffScheduleDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertstaffSchedule(String time, String task){
        String query = "INSERT INTO staff_schedule (time,task) VALUES) (?,?)";

        int result = jdbcTemplate.update(query, time, task);

        if (result > 0){
            System.out.println(result + "Staff Scedule added to database");

        }
    }
    public StaffSchedule getStaffTask(int staff_id, String time){
        String query = "SELECT * FROM staff_schedule WHERE staff_id =? AND time=?";
        StaffSchedule staffSchedule = jdbcTemplate.queryForObject(query, new staffScheduleMapper(), staff_id, time);
        return staffSchedule;
    }
    private class staffScheduleMapper implements RowMapper <StaffSchedule> {
        @Override
        public StaffSchedule mapRow(ResultSet rs, int rowNum) throws SQLException {
            StaffSchedule sts = new StaffSchedule(rs.getInt("staff_id"),
                    rs.getString("time"),
                    rs.getString("task"));

            return sts;
        }
    }
}
