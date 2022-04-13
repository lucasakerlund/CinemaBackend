package com.example.cinemabackend.api;

import com.example.cinemabackend.model.Salon;
import com.example.cinemabackend.service.SalonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/v1/salons")
@RestController
public class SalonController {

    private final SalonService service;

    public SalonController(SalonService service){
        this.service = service;
    }

    @GetMapping
    public List<Salon> getSalons(){
        return service.getSalons();
    }

}
