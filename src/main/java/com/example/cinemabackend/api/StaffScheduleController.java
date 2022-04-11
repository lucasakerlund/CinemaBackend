package com.example.cinemabackend.api;

import com.example.cinemabackend.model.StaffSchedule;
import com.example.cinemabackend.service.StaffScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/staff_schedules")
@RestController
public class StaffScheduleController {

    private final StaffScheduleService service;

    public StaffScheduleController(StaffScheduleService service){
        this.service = service;
    }

    @GetMapping("{id}/{date}/{time}")
    public StaffSchedule getStaffSchedule(@PathVariable("id") int staffId, @PathVariable("date") String date, @PathVariable("time") String time){
        return service.getStaffScheduleById(staffId, date, time);
    }

    @GetMapping
    public List<StaffSchedule> getStaffSchedules(){
        return service.getStaffSchedules();
    }

    @GetMapping("{id}")
    public List<StaffSchedule> getStaffSchedulesByStaffId(@PathVariable("id") int staffId){
        return service.getStaffSchedulesByStaffId(staffId);
    }

    @PostMapping
    public void createTask(@RequestBody StaffSchedule staffSchedule){
        service.insertStaffSchedule(staffSchedule.getStaffId(), staffSchedule.getDate(), staffSchedule.getTime(), staffSchedule.getTask());
    }

}
