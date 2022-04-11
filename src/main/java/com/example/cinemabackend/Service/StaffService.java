package com.example.cinemabackend.service;

import com.example.cinemabackend.dao.StaffDao;
import com.example.cinemabackend.model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    @Autowired
    StaffDao staffDao;
    public void InsertStaff(Staff staff){
        staffDao.insertStaff(staff.getName(),staff.getAddress(),staff.getPosition());
    }

    public Staff getStaffById(int staffId) {
        Staff staff = staffDao.getStaffById(staffId);
        return staff;
    }

    public List<Staff> getStaffs(){
        return staffDao.getStaffs();
    }

}
