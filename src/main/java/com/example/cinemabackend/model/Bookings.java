package com.example.cinemabackend.model;

public class Bookings {
    private int bookingId;
    private int customerId;
    private int adults;
    private int children;
    private int seniors;
    private int students;
    private int scheduleId;
    private int salonId;

    public Bookings(int bookingId, int adults, int children, int scheduleId, int salonId) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.adults = adults;
        this.children = children;
        this.seniors = seniors;
        this.students = students;
        this.scheduleId = scheduleId;
        this.salonId = salonId;
    }

    public int getBookingId() {return bookingId;}

    public void setBookingId(int bookingId) {this.bookingId = bookingId;}

    public int getCustomerId() {return customerId;}

    public void setCustomerId(int customerId) {this.customerId = customerId;}

    public int getAdults() {return adults;}

    public void setAdults(int adults) {this.adults = adults;}

    public int getChildren() {return children;}

    public int getSeniors() {return seniors;}

    public void setSeniors(int seniors) {this.seniors = seniors;}

    public int getStudents() {return students;}

    public void setStudents(int students) {this.students = students;}

    public void setChildren(int children) {this.children = children;}

    public int getScheduleId() {return scheduleId;}

    public void setScheduleId(int scheduleId) {this.scheduleId = scheduleId;}

    public int getSalonId() {return scheduleId;}

    public void setSalonId(int salonId) {this.salonId = salonId;}

    @Override
    public String toString() {
        return "Bookings{" +
                "bookingId=" + bookingId +
                ", customerId=" + customerId +
                ", adults=" + adults +
                ", children=" + children +
                ", seniors=" + seniors +
                ", students=" + students +
                ", scheduleId=" + scheduleId +
                ", salonId=" + salonId +
                '}';
    }
}
