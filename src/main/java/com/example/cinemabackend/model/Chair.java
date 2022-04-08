package com.example.cinemabackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Chair {
    private int chairNumber;
    private int salon;

    public Chair(@JsonProperty("chair_number") int chairNumber,
                 @JsonProperty("salon_id") int salon){
        this.chairNumber = chairNumber;
        this.salon = salon;
    }

    public int getChairNumber() {return chairNumber;}

    public void setChairNumber(int chairNumber) {this.chairNumber = chairNumber;}

    public int getSalon() {return salon;}

    public void setSalon(int salon) {this.salon = salon;}

    @Override
    public String toString() {
        return "Chairs{" +
                "chairNumber=" + chairNumber +
                ", salon=" + salon +
                '}';
    }
}
