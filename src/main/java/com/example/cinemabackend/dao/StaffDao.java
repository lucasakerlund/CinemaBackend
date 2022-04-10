package com.example.cinemabackend.dao;

import com.example.cinemabackend.model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class StaffDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertStaff(String name,String address,String position) {
        String query = "INSERT INTO staff(name,address,position)VALUES)(?,?,?)";

        int result = jdbcTemplate.update(query,name,address,position);

        if(result > 0){
            System.out.println(result + "staff added to database");

        }

    }
    public Staff getStaffById(String staff_id){
        String query = "SELECT * FROM staff WHERE staff_id =?";
        Staff staff = jdbcTemplate.queryForObject(query,new StaffMapper());
        return staff;
    }
    private class StaffMapper implements RowMapper<Staff> {
        @Override
        public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {
            Staff sta = new Staff(rs.getInt("staff_id"),
                    rs.getString("name"),
                    rs.getString("address"),
                    rs.getString("position"),
                    rs.getInt("salary"),
                    rs.getString("position"));

            return sta;


        }

    }



}
