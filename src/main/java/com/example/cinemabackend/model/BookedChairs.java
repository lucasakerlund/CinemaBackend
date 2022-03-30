package com.example.cinemabackend.model;

public class BookedChairs {
    private int bookingId;
    private int scheduleId;
    private int chairNumber;

    public BookedChairs (int bookingId, int scheduleId, int chairNumber) {
        this.bookingId = bookingId;
        this.scheduleId = scheduleId;
        this.chairNumber = chairNumber;
    }

    public int getBookingId() {return bookingId;}

    public void setBookingId(int bookingId) {this.bookingId = bookingId;}

    public int getScheduleId() {return scheduleId;}

    public void setScheduleId(int scheduleId) {this.scheduleId = scheduleId;}

    public int getChairNumber() {return chairNumber;}

    public void setChairNumber(int chairNumber) {this.chairNumber = chairNumber;}

    @Override
    public String toString() {
        return "BookedChairs{" +
                "bookingId=" + bookingId +
                ", scheduleId=" + scheduleId +
                ", chairNumber=" + chairNumber +
                '}';
    }
}
