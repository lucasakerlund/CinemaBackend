package com.example.cinemabackend.api;

import com.example.cinemabackend.model.Staff;
import com.example.cinemabackend.service.StaffService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/staffs")
@RestController
public class StaffController {

    private final StaffService service;

    public StaffController(StaffService service){
        this.service = service;
    }

    @GetMapping("{id}")
    public Staff getStaffById(@PathVariable("id") int staffId){
        return service.getStaffById(staffId);
    }

    @GetMapping("security_number/{id}")
    public Staff getStaffBySecurityNumber(@PathVariable("id") String securityNumber){
        return service.getStaffBySecurityNumber(securityNumber);
    }

    @GetMapping
    public List<Staff> getStaffs(){
        return service.getStaffs();
    }

}
