package com.example.cinemabackend.dao;

import com.example.cinemabackend.model.Staff;
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
public class StaffDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertStaff(String name,String address,String position) {
        String query = "INSERT INTO staffs(name,address,position)VALUES)(?,?,?)";

        int result = jdbcTemplate.update(query,name,address,position);

        if(result > 0){
            System.out.println(result + "staff added to database");

        }

    }

    public List<Staff> getStaffs(){
        String query = "SELECT * FROM staffs";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query);
        List<Staff> output = new ArrayList<>();
        while(rowSet.next()){
            output.add(new Staff(rowSet.getInt("staff_id"),
                    rowSet.getString("name"),
                    rowSet.getString("security_number"),
                    rowSet.getString("mail"),
                    rowSet.getString("address"),
                    rowSet.getInt("salary"),
                    rowSet.getString("position")));
        }
        return output;
    }

    public Staff getStaffBySecurityNumber(String securityNumber){
        String query = "SELECT * FROM staffs WHERE security_number =?";
        try {
            return jdbcTemplate.queryForObject(query, (rs, rowNum) -> {
                return new Staff(rs.getInt("staff_id"),
                        rs.getString("name"),
                        rs.getString("security_number"),
                        rs.getString("mail"),
                        rs.getString("address"),
                        rs.getInt("salary"),
                        rs.getString("position"));
            }, securityNumber);
        }catch(Exception e) {
            return null;
        }
    }

    public Staff getStaffById(int staffId){
        String query = "SELECT * FROM staffs WHERE staff_id =?";
        Staff staff = jdbcTemplate.queryForObject(query,new StaffMapper(), staffId);
        return staff;
    }
    private class StaffMapper implements RowMapper<Staff> {
        @Override
        public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {
            Staff sta = new Staff(rs.getInt("staff_id"),
                    rs.getString("name"),
                    rs.getString("security_number"),
                    rs.getString("mail"),
                    rs.getString("address"),
                    rs.getInt("salary"),
                    rs.getString("position"));

            return sta;


        }

    }



}
