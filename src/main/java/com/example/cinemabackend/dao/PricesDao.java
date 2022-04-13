package com.example.cinemabackend.dao;

import com.example.cinemabackend.model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        return getPrices().stream().filter(p -> p.getProduct().equals(product)).findFirst().orElse(null);
    }

    public List<Price> getPrices(){
        String query = "SELECT * FROM prices";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query);

        List<Price> output = new ArrayList<>();
        while(rowSet.next()){
            output.add(new Price(rowSet.getString("product"),
                    rowSet.getInt("price")));
        }
        return output;
    }

}
