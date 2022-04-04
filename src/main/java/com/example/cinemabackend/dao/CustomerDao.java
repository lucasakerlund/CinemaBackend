package com.example.cinemabackend.dao;

import com.example.cinemabackend.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class CustomerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertCustomer(String name,String mail){
        String query = "Insert INTO customers(name,mail )VALUES(?,?)";

        int result = jdbcTemplate.update(query,name,mail);

        if(result > 0){
            System.out.println(result + "customer added to database");
        }

    }
    public Customer getCustomerById(String customer_id){
        String query = "SELECT * FROM customers WHERE customer_id =?";
        Customer customer = jdbcTemplate.queryForObject(query,new CustomerMapper());
        return customer;

        }
    private class CustomerMapper implements RowMapper<Customer> {

        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer cus = new Customer(rs.getInt("customer_id"),
                    rs.getString("name"),
                    rs.getString("mail"));
            return cus;

        }
    }
    }




