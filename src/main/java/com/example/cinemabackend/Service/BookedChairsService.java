package com.example.cinemabackend.service;

import com.example.cinemabackend.dao.BookedChairsDao;
import com.example.cinemabackend.model.BookedChair;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookedChairsService {

    private final BookedChairsDao dao;

    public BookedChairsService(@Qualifier("bookedChairs") BookedChairsDao dao){
        this.dao = dao;
    }

    public List<BookedChair> getBookedChairsByBookingId(int bookingId){
        return dao.getBookedChairsByBookingId(bookingId);
    }

    public String[] getTakenChairs(String scheduleId){
        return dao.getTakenChairs(scheduleId);
    }

}
