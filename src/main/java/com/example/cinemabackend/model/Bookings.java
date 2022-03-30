package com.example.cinemabackend.model;

public class Bookings {
    private int bookingId;
    private int adults;
    private int children;
    private int scheduleId;
    private int salonId;

    public Bookings(int bookingId, int adults, int children, int scheduleId, int salonId) {
        this.bookingId = bookingId;
        this.adults = adults;
        this.children = children;
        this.scheduleId = scheduleId;
        this.salonId = salonId;
    }

    public int getBookingId() {return bookingId;}

    public void setBookingId(int bookingId) {this.bookingId = bookingId;}

    public int getAdults() {return adults;}

    public void setAdults(int adults) {this.adults = adults;}

    public int getChildren() {return children;}

    public void setChildren(int children) {this.children = children;}

    public int getScheduleId() {return scheduleId;}

    public void setScheduleId(int scheduleId) {this.scheduleId = scheduleId;}

    public int getSalonId() {return scheduleId;}

    public void setSalonId(int salonId) {this.salonId = salonId;}

    @Override
    public String toString() {
        return "Bookings{" +
                "bookingId=" + bookingId +
                ", adults=" + adults +
                ", children=" + children +
                ", scheduleId=" + scheduleId +
                ", salonId=" + salonId +
                '}';
    }
}
