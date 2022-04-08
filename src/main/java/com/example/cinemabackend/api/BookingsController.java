package com.example.cinemabackend.api;

import com.example.cinemabackend.service.BookingsService;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/bookings")
@RestController
public class BookingsController {

    private final BookingsService service;

    public BookingsController(BookingsService service){
        this.service = service;
    }

    @PostMapping
    public void addTicket(@RequestBody JSONObject object){
        System.out.println(object.toString());
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

}
