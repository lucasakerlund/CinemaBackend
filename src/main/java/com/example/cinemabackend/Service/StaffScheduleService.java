package com.example.cinemabackend.service;

import com.example.cinemabackend.dao.StaffScheduleDao;
import com.example.cinemabackend.model.StaffSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffScheduleService {
    @Autowired
    StaffScheduleDao staffScheduleDAO;

    public void insertStaffSchedule(StaffSchedule staffSchedule) {
        staffSchedule.insertStaffSchedule(staffSchedule.getTime(), staffSchedule.getTask());
    }
    public StaffSchedule getStaffScheduleById(int staff_id, String time) {
        return staffScheduleDAO.getStaffTask(staff_id, time);
    }
}
