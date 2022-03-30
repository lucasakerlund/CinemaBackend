package com.example.cinemabackend.model;

public class Salons {
    private int salonId;

    public Salons(int SalonId) {
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
