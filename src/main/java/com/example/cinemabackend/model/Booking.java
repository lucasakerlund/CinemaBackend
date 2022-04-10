package com.example.cinemabackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Booking {
    private int bookingId;
    private int customerId;
    private int scheduleId;
    private int adults;
    private int children;
    private int seniors;
    private int students;

    public Booking(@JsonProperty("booking_id") int bookingId,
                   @JsonProperty("customer_id") int customerId,
                   @JsonProperty("schedule_id") int scheduleId,
                   @JsonProperty("adults") int adults,
                   @JsonProperty("children") int children,
                   @JsonProperty("seniors") int seniors,
                   @JsonProperty("students") int students) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.scheduleId = scheduleId;
        this.adults = adults;
        this.children = children;
        this.seniors = seniors;
        this.students = students;
    }

    public int getBookingId() {return bookingId;}

    public void setBookingId(int bookingId) {this.bookingId = bookingId;}

    public int getCustomerId() {return customerId;}

    public void setCustomerId(int customerId) {this.customerId = customerId;}

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public int getAdults() {return adults;}

    public void setAdults(int adults) {this.adults = adults;}

    public int getChildren() {return children;}

    public int getSeniors() {return seniors;}

    public void setSeniors(int seniors) {this.seniors = seniors;}

    public int getStudents() {return students;}

    public void setStudents(int students) {this.students = students;}

    public void setChildren(int children) {this.children = children;}

}
