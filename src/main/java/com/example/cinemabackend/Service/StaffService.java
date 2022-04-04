package com.example.cinemabackend.Service;

import com.example.cinemabackend.dao.StaffDao;
import org.springframework.beans.factory.annotation.Autowired;

public class StaffService {


    @Autowired
    StaffDao staffDao;
    public void InsertStaff(Staff staff){
        staffDao.InsertStaff(staff,getName(),staff.getAdress(),staff.getPosition());
    }

    public Staff getStaffById(String staff_id) {
        Staff staff = staffDao.getStaffById();
        return staff;
    }


}
