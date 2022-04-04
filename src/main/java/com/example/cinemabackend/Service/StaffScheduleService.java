package com.example.cinemabackend.service;

import com.example.cinemabackend.dao.StaffScheduleDAO;
import com.example.cinemabackend.model.Staff;
import com.example.cinemabackend.model.StaffSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffScheduleService {
    @Autowired
    StaffScheduleDAO staffScheduleDAO;

    public void insertStaffSchedule(StaffSchedule staffSchedule) {
        staffSchedule.insertStaffSchedule(staffSchedule.getTime(), staffSchedule.getTask());
    }
    public StaffSchedule getStaffScheduleById(String staff_id) {

        StaffSchedule staffSchedule = staffScheduleDAO.getStaffScheduleById(staff_id);
        return staffSchedule;
    }
}
