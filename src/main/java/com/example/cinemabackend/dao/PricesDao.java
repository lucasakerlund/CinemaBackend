package com.example.cinemabackend.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

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
    public Prices getPricesById(String product){
        String query = "SELECT * FROM prices WHERE product =?";
        Prices prices = jdbcTemplate.queryForObject(query,new PricesMapper())
                return prices;
    }

    private class PricesMapper implements RowMapper<Prices> {

        @Override
        public Prices mapRpw(ResultSet rs, int rowNum) throws SQLException {
            Prices pri = new Prices(rs.getInt(product),
                    rs.getString(product));
            return pri;
        }
    }



}
