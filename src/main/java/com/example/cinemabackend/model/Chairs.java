package com.example.cinemabackend.model;

public class Chairs {
    private int chairNumber;
    private int salon;

    public Chairs (int chairNumber, int Salon){
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
