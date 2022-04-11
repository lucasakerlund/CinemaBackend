package com.example.cinemabackend.dao;

import com.example.cinemabackend.model.Staff;
import com.example.cinemabackend.model.StaffSchedule;
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
public class StaffScheduleDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertstaffSchedule(String time, String task){
        String query = "INSERT INTO staff_schedules (time,task) VALUES) (?,?)";

        int result = jdbcTemplate.update(query, time, task);

        if (result > 0){
            System.out.println(result + "Staff Scedule added to database");

        }
    }

    public List<StaffSchedule> getStaffSchedulesByStaffId(int staffId){
        String query = "SELECT * FROM staff_schedule WHERE staff_id =?";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query, staffId);
        List<StaffSchedule> output = new ArrayList<>();
        while(rowSet.next()){
            output.add(new StaffSchedule(rowSet.getInt("staff_id"),
                    rowSet.getString("time"),
                    rowSet.getString("task")));
        }
        return output;
    }

    public StaffSchedule getStaffTask(int staffId, String time){
        String query = "SELECT * FROM staff_schedules WHERE staff_id =? AND time=?";
        StaffSchedule staffSchedule = jdbcTemplate.queryForObject(query, new staffScheduleMapper(), staffId, time);
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
