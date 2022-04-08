package com.example.cinemabackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Price {
    private String product;
    private int price;

    public Price(@JsonProperty("product") String product,
                 @JsonProperty("price") int price) {
        this.product = product;
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Prices{" +
                "product=" + product +
                "price= " + price +
                '}';
    }
}
