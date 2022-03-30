package com.example.cinemabackend.model;

public class Salons {
    private int SalonId;

    public Salons(int SalonId) {
        this.SalonId = SalonId;
    }

    public int getSalonId() {return SalonId;}

    public void setSalonId(int SalonId) {this.SalonId = SalonId;}

    @Override
    public String toString() {
        return "Salons{" +
                "SalonId=" + SalonId +
                '}';
    }
}
