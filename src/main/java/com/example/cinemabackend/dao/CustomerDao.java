package com.example.cinemabackend.dao;

import com.example.cinemabackend.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class CustomerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertCustomer(String name, String securityNumber, String mail){
        String query = "Insert INTO customers(name, security_number, mail )VALUES(?,?,?)";
        jdbcTemplate.update(query, name, securityNumber, mail);
    }

    public boolean isSecurityNumberAvailable(String securityNumber){
        String query = "SELECT * FROM customers WHERE security_number = ?";
        return !jdbcTemplate.queryForRowSet(query, securityNumber).next();
    }

    public Customer getCustomerBySecurityNumber(String securityNumber){
        String query = "SELECT * FROM customers WHERE security_number =?";
        Customer customer = jdbcTemplate.queryForObject(query,new CustomerMapper(), securityNumber);
        return customer;
    }

    private class CustomerMapper implements RowMapper<Customer> {

        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer cus = new Customer(rs.getInt("customer_id"),
                    rs.getString("name"),
                    rs.getString("security_number"),
                    rs.getString("mail"));
            return cus;

        }
    }
    }




