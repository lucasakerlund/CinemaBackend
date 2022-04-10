package com.example.cinemabackend.dao;

import com.example.cinemabackend.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlTypeValue;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("booking")
public class BookingsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Booking> getBookingsByCustomerId(int customerId){
        String query = "SELECT * FROM bookings WHERE customer_id =?";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query, customerId);
        List<Booking> output = new ArrayList<>();
        while(rowSet.next()){
            output.add(new Booking(rowSet.getInt("booking_id"),
                    rowSet.getInt("customer_id"),
                    rowSet.getInt("schedule_id"),
                    rowSet.getInt("adults"),
                    rowSet.getInt("children"),
                    rowSet.getInt("seniors"),
                    rowSet.getInt("students")));
        }
        return output;
    }

    public void addTicket(String customerId, String amountOfAdults, String amountOfChildren, String amountOfSeniors, String amountOfStudents, String scheduleId, String chairNumbers){
        String query = "call book_ticket (?,?,?,?,?,?,?)";

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("book_ticket");
        Map<String, String> inParams = new HashMap<>();
        inParams.put("customer_id", customerId);
        inParams.put("amount_of_adults", amountOfAdults);
        inParams.put("amount_of_children", amountOfChildren);
        inParams.put("amount_of_seniors", amountOfSeniors);
        inParams.put("amount_of_students", amountOfStudents);
        inParams.put("schedule_id", scheduleId);
        inParams.put("chair_numbers", chairNumbers);

        SqlParameterSource in = new MapSqlParameterSource(inParams);
        jdbcCall.execute(in);
    }

    public boolean deleteBooking(int bookingId){
        String query = "call remove_ticket (?)";

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("remove_ticket")
                .declareParameters(
                        new SqlOutParameter("succeed", Types.INTEGER));

        Map<String, String> inParams = new HashMap<>();
        inParams.put("booking_id", bookingId+"");

        SqlParameterSource in = new MapSqlParameterSource(inParams);

        return (int) jdbcCall.execute(in).get("succeed") >= 1;
    }

    public Booking getBookingById(int bookingId){
        String query = "SELECT * FROM customers WHERE customer_id =?";
        Booking booking = jdbcTemplate.queryForObject(query,(rs, rowNum) -> {
            Booking b = new Booking(
                    rs.getInt("booking_id"),
                    rs.getInt("customer_id"),
                    rs.getInt("schedule_id"),
                    rs.getInt("adults"),
                    rs.getInt("children"),
                    rs.getInt("seniors"),
                    rs.getInt("students"));
            return b;
        }, bookingId);
        return booking;

    }

}
