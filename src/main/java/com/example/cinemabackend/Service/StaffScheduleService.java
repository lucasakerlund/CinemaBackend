package com.example.cinemabackend.service;

import com.example.cinemabackend.dao.StaffScheduleDao;
import com.example.cinemabackend.model.StaffSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffScheduleService {

    @Autowired
    StaffScheduleDao staffScheduleDAO;

    public void insertStaffSchedule(StaffSchedule staffSchedule) {
        staffSchedule.insertStaffSchedule(staffSchedule.getTime(), staffSchedule.getTask());
    }
    public StaffSchedule getStaffScheduleById(int staffId, String time) {
        return staffScheduleDAO.getStaffTask(staffId, time);
    }

    public List<StaffSchedule> getStaffSchedulesByStaffId(int staffId){
        return staffScheduleDAO.getStaffSchedulesByStaffId(staffId);
    }
}
