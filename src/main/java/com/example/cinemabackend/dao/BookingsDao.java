package com.example.cinemabackend.dao;

import com.example.cinemabackend.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository("booking")
public class BookingsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

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
        System.out.println(jdbcCall.execute(in));
    }
    public Booking getBookingById(int bookingId){
        String query = "SELECT * FROM customers WHERE customer_id =?";
        Booking booking = jdbcTemplate.queryForObject(query,(rs, rowNum) -> {
            Booking b = new Booking(
                    rs.getInt("booking_id"),
                    rs.getInt("customer_id"),
                    rs.getInt("adults"),
                    rs.getInt("children"),
                    rs.getInt("seniors"),
                    rs.getInt("students"),
                    rs.getInt("schedule_id"),
                    rs.getInt("salon_id"));
            return b;
        });
        return booking;

    }

}
