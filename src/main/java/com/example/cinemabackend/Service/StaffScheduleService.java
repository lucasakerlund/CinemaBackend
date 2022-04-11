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

    public void insertStaffSchedule(int staffId, String date, String time, String task) {
        staffScheduleDAO.insertStaffSchedule(staffId, date, time, task);
    }

    public List<StaffSchedule> getStaffSchedules(){
        return staffScheduleDAO.getStaffSchedules();
    }

    public List<StaffSchedule> getStaffSchedulesByStaffId(int staffId){
        return staffScheduleDAO.getStaffSchedulesByStaffId(staffId);
    }

    public StaffSchedule getStaffScheduleById(int staffId, String date, String time) {
        return staffScheduleDAO.getStaffTask(staffId, date, time);
    }
}
