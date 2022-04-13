package com.example.cinemabackend.api;

import com.example.cinemabackend.model.Movie;
import com.example.cinemabackend.model.Schedule;
import com.example.cinemabackend.service.ScheduleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/v1/schedules")
@RestController
public class SchedulesController {

    private final ScheduleService service;

    public SchedulesController(ScheduleService service){
        this.service = service;
    }

    @GetMapping(path = "{id}")
    public Schedule getScheduleById(@PathVariable("id") int scheduleId){
        return service.getScheduleById(scheduleId);
    }

    @GetMapping(path = "movie/{id}")
    public List<Schedule> getSchedulesByMovie(@PathVariable("id") int movieId){
        return service.getSchedulesByMovie(movieId);
    }

    @GetMapping
    public List<Schedule> getSchedules(){
        return service.getSchedules();
    }

}
