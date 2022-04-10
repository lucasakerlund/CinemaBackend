package com.example.cinemabackend.service;

import com.example.cinemabackend.api.BookingsController;
import com.example.cinemabackend.dao.BookingsDao;
import com.example.cinemabackend.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingsService {

    private final BookingsDao dao;

    public BookingsService(@Qualifier("booking") BookingsDao dao){
        this.dao = dao;
    }

    public List<Booking> getBookingsByCustomerId(int customerId){
        return dao.getBookingsByCustomerId(customerId);
    }

    public void addTicket(String customerId, String amountOfAdults, String amountOfChildren, String amountOfSeniors, String amountOfStudents, String scheduleId, String chairNumbers){
        dao.addTicket(customerId, amountOfAdults, amountOfChildren, amountOfSeniors, amountOfStudents, scheduleId, chairNumbers);
    }

    public boolean deleteBooking(int bookingId){
        return dao.deleteBooking(bookingId);
    }

}
