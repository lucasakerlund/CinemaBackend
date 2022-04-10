package com.example.cinemabackend.service;


import com.example.cinemabackend.dao.CustomerDao;
import com.example.cinemabackend.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerDao customerDao;

    public void insertCustomer(String name, String securityNumber, String mail){
        customerDao.insertCustomer(name, securityNumber, mail);

    }
    public Customer getCustomerBySecurityNumber(String securityNumber){
        Customer customer = customerDao.getCustomerBySecurityNumber(securityNumber);
        return customer;
    }

    public boolean isSecurityNumberAvailable(String securityNumber){
        return customerDao.isSecurityNumberAvailable(securityNumber);
    }

}
