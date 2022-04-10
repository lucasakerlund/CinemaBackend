package com.example.cinemabackend.api;

import com.example.cinemabackend.model.BookedChair;
import com.example.cinemabackend.service.BookedChairsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/v1/booked_chairs")
@RestController
public class BookedChairsController {

    private final BookedChairsService service;

    public BookedChairsController(BookedChairsService service){
        this.service = service;
    }

    @GetMapping(path = "booked_chairs/{id}")
    public List<BookedChair> getBookedChairsByBookingId(@PathVariable("id") int bookingId){
        return service.getBookedChairsByBookingId(bookingId);
    }

    @GetMapping(path = "taken_chairs/{id}")
    public String[] getTakenChairs(@PathVariable("id") String scheduleId){
        return service.getTakenChairs(scheduleId);
    }

}
