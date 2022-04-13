package com.example.cinemabackend.api;

import com.example.cinemabackend.model.Price;
import com.example.cinemabackend.service.PricesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/v1/prices")
@RestController
public class PriceController {

    private final PricesService service;

    public PriceController(PricesService service){
        this.service = service;
    }

    @GetMapping
    public List<Price> getPrices(){
        return service.getPrices();
    }

}
