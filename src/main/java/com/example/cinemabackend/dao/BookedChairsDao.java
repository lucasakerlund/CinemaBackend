package com.example.cinemabackend.dao;

import com.example.cinemabackend.model.BookedChair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("bookedChairs")
public class BookedChairsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<BookedChair> getBookedChairsByBookingId(int bookingId){
        String query = "SELECT * FROM booked_chairs WHERE booking_id =?";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query, bookingId);
        List<BookedChair> output = new ArrayList<>();
        while(rowSet.next()){
            output.add(new BookedChair(rowSet.getInt("booking_id"),
                    rowSet.getInt("schedule_id"),
                    rowSet.getInt("chair_number")));
        }
        return output;
    }

    public String[] getTakenChairs(String scheduleID){
        String query = "SELECT * FROM booked_chairs WHERE schedule_id =?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query, scheduleID);
        List<String> output = new ArrayList<>();
        while(rowSet.next()){
            output.add(rowSet.getInt("chair_number")+"");
        }
        return (String[]) output.toArray(new String[0]);
    }

}
