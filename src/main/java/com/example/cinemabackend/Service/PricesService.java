package com.example.cinemabackend.service;

import com.example.cinemabackend.dao.PricesDao;
import com.example.cinemabackend.model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PricesService {

    @Autowired
    PricesDao pricesDao;
    public void InsertPrices(Price prices){
        pricesDao.insertPrices(prices.getProduct());
    }
    public Price getPricesById(String product){
        Price prices = pricesDao.getPricesById(product);
        return prices;
    }

    public List<Price> getPrices(){
        return pricesDao.getPrices();
    }

}
