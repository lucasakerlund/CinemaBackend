package com.example.cinemabackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Salon {
    private int salonId;

    public Salon(@JsonProperty("salon_id") int SalonId) {
        this.salonId = SalonId;
    }

    public int getSalonId() {return salonId;}

    public void setSalonId(int salonId) {this.salonId = salonId;}

    @Override
    public String toString() {
        return "Salons{" +
                "salonId=" + salonId +
                '}';
    }
}
