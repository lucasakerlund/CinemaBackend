package com.example.cinemabackend.api;

import com.example.cinemabackend.model.StaffSchedule;
import com.example.cinemabackend.service.StaffScheduleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/v1/staff_schedules")
@RestController
public class StaffScheduleController {

    private final StaffScheduleService service;

    public StaffScheduleController(StaffScheduleService service){
        this.service = service;
    }

    @GetMapping("{id}/{time}")
    public StaffSchedule getStaffSchedule(@PathVariable("id") int staffId, @PathVariable("time") String time){
        return service.getStaffScheduleById(staffId, time);
    }

    @GetMapping("{id}")
    public List<StaffSchedule> getStaffSchedulesByStaffId(@PathVariable("id") int staffId){
        return service.getStaffSchedulesByStaffId(staffId);
    }

}
