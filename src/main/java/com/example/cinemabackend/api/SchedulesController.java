package com.example.cinemabackend.api;

import com.example.cinemabackend.model.Movie;
import com.example.cinemabackend.model.Schedule;
import com.example.cinemabackend.service.ScheduleService;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public void createSchedule(@RequestBody Schedule schedule){
        service.createSchedule(schedule.getDate(), schedule.getTime(), schedule.getMovieId(), schedule.getSalon());
    }

}
