package com.example.cinemabackend.service;


import com.example.cinemabackend.dao.ScheduleDao;
import com.example.cinemabackend.model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    ScheduleDao scheduleDao;

    public void InsertSchedule(Schedule schedule)  {
        scheduleDao.insertSchedule(schedule.getDate(),schedule.getTime());
    }

    public Schedule getScheduleById(int scheduleId) {
        return scheduleDao.getScheduleById(scheduleId);
    }

    public List<Schedule> getSchedulesByMovie(int movieId){
        return scheduleDao.getSchedulesByMovie(movieId);
    }
}
