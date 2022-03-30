package com.example.cinemabackend.Service;


import com.example.cinemabackend.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerDao customerDao;
    public void InsertCustomer(Customer customer){
        customerDao.insertCustomer(customer.getName(),customer.getmail());

    }

    public Customer getCustomerById(String customer_id){
        Customer customer = customerDao.getCustomerById(customer_id);
        return customer;
    }

}
