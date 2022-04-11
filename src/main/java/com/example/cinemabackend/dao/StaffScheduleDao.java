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
import java.util.stream.Collectors;

@Repository
public class StaffScheduleDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertStaffSchedule(int staffId, String date, String time, String task){
        String query = "INSERT INTO staff_schedules (staff_id, date, time,task) VALUES (?,?,?,?)";

        int result = jdbcTemplate.update(query, staffId, date, time, task);

        if (result > 0){
            System.out.println(result + "Staff Scedule added to database");

        }
    }

    public List<StaffSchedule> getStaffSchedules(){
        String query = "SELECT * FROM staff_schedules";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query);
        List<StaffSchedule> output = new ArrayList<>();
        while(rowSet.next()){
            output.add(new StaffSchedule(rowSet.getInt("staff_id"),
                    rowSet.getString("date"),
                    rowSet.getString("time"),
                    rowSet.getString("task")));
        }
        return output;
    }

    public List<StaffSchedule> getStaffSchedulesByStaffId(int staffId){
        return getStaffSchedules().stream().filter(s -> s.getStaffId() == staffId).collect(Collectors.toList());
    }

    public StaffSchedule getStaffTask(int staffId, String date, String time){
        String query = "SELECT * FROM staff_schedules WHERE staff_id =? AND date =? AND time=?";
        try {
            return jdbcTemplate.queryForObject(query, new staffScheduleMapper(), staffId, date, time);
        }catch(Exception e){
            return null;
        }
    }
    private class staffScheduleMapper implements RowMapper <StaffSchedule> {
        @Override
        public StaffSchedule mapRow(ResultSet rs, int rowNum) throws SQLException {
            StaffSchedule sts = new StaffSchedule(rs.getInt("staff_id"),
                    rs.getString("date"),
                    rs.getString("time"),
                    rs.getString("task"));

            return sts;
        }
    }
}
