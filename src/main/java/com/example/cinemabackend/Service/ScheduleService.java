package com.example.cinemabackend.Service;


import com.example.cinemabackend.dao.ScheduleDao;
import com.example.cinemabackend.model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    @Autowired
    ScheduleDao scheduleDao;
    public void InsertSchedule(Schedule schedule)  {
        scheduleDao.insertSchedule(schedule.getDate(),schedule.getTime());
    }

    public Schedule getScheduleById(String movie_id) {

        Schedule schedule = scheduleDao.getScheduleById(movie_id);
        return schedule;
    }
}
