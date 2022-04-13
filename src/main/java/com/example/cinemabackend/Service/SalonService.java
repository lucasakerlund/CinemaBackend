package com.example.cinemabackend.service;

import com.example.cinemabackend.dao.SalonDao;
import com.example.cinemabackend.model.Salon;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalonService {

    private SalonDao dao;

    public SalonService(@Qualifier("salons") SalonDao dao){
        this.dao = dao;
    }

    public List<Salon> getSalons(){
        return dao.getSalons();
    }

}
