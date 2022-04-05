package com.example.cinemabackend.Service;

import com.example.cinemabackend.dao.PricesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PricesService {

    @Autowired
    PricesDao pricesDao;
    public void InsertPrices(Prices prices){
        pricesDao.InsertPrices(prices.getProduct());
    }
    public Prices getPricesById(String product){
        Prices prices = pricesDao.getPricesById(product);
        return prices;
    }
}
