package com.example.cinemabackend.dao;

import com.example.cinemabackend.model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class PricesDao {
    @Autowired

    private JdbcTemplate jdbcTemplate;

    public void insertPrices(String product) {
        String query = "INSERT INTO prices(product)VALUES(?)";
        int result = jdbcTemplate.update(query,product);

        if(result > 0){
            System.out.println(result + "Prices added to database");
        }
    }
    public Price getPricesById(String product){
        String query = "SELECT * FROM prices WHERE product =?";
        Price price = jdbcTemplate.queryForObject(query,(rs, rowNum) -> {
            Price p = new Price(rs.getString("product"), rs.getInt("price"));
            return p;
        });
        return price;
    }



}
