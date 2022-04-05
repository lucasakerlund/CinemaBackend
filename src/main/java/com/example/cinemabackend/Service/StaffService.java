package com.example.cinemabackend.Service;

import com.example.cinemabackend.dao.StaffDao;
import com.example.cinemabackend.model.Staff;
import org.springframework.beans.factory.annotation.Autowired;

public class StaffService {


    @Autowired
    StaffDao staffDao;
    public void InsertStaff(Staff staff){
        staffDao.insertStaff(staff.getName(),staff.getAddress(),staff.getPosition());
    }

    public Staff getStaffById(String staff_id) {
        Staff staff = staffDao.getStaffById(staff_id);
        return staff;
    }


}
