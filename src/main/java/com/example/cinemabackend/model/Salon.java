package com.example.cinemabackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Salon {

    @JsonProperty("salon_id")
    private int salonId;

    public Salon(@JsonProperty("salon_id") int SalonId) {
        this.salonId = SalonId;
    }

    public int getSalonId() {return salonId;}

    public void setSalonId(int salonId) {this.salonId = salonId;}

}
