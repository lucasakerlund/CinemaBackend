package com.example.cinemabackend.service;

import com.example.cinemabackend.api.BookingsController;
import com.example.cinemabackend.dao.BookingsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BookingsService {

    private final BookingsDao dao;

    public BookingsService(@Qualifier("booking") BookingsDao dao){
        this.dao = dao;
    }

    public void addTicket(String customerId, String amountOfAdults, String amountOfChildren, String amountOfSeniors, String amountOfStudents, String scheduleId, String chairNumbers){
        dao.addTicket(customerId, amountOfAdults, amountOfChildren, amountOfSeniors, amountOfStudents, scheduleId, chairNumbers);
    }

}
