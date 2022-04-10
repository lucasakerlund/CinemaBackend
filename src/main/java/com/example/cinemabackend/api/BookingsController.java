package com.example.cinemabackend.api;

import com.example.cinemabackend.model.Booking;
import com.example.cinemabackend.service.BookingsService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/bookings")
@RestController
public class BookingsController {

    private final BookingsService service;

    public BookingsController(BookingsService service){
        this.service = service;
    }

    @GetMapping(path = "{id}")
    public List<Booking> getBookingsByCustomerId(@PathVariable("id") int customerId){
        return service.getBookingsByCustomerId(customerId);
    }

    @PostMapping
    public void addTicket(@RequestBody String data){
        JSONObject object = new JSONObject(data);
        service.addTicket(
                object.getInt("customer_id")+"",
                object.getInt("amount_of_adults")+"",
                object.getInt("amount_of_children")+"",
                object.getInt("amount_of_seniors")+"",
                object.getInt("amount_of_students")+"",
                object.getInt("schedule_id")+"",
                object.getString("chair_numbers")
                );
    }

    @GetMapping(path = "delete/{id}")
    public boolean deleteBooking(@PathVariable("id") int bookingId){
        return service.deleteBooking(bookingId);
    }

}
