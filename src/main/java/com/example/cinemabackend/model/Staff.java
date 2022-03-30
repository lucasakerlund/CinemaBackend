package com.example.cinemabackend.model;

public class Staff {
    private int staffId;
    private String name;
    private String securityNumber;
    private String address;
    private int salary;
    private String position;

    public Staff (int staffId, String name, String securityNumber, String address, int salary, String position) {
        this.staffId = staffId;
        this.name = name;
        this.securityNumber = securityNumber;
        this.address = address;
        this.salary = salary;
        this.position = position;
    }

    public int getStaffId() {return staffId;}

    public void setStaffId(int staffid) {this.staffId = staffid;}

    public String getName() {return name;}

    public void setName (String name) {this.name = name;}

    public String getSecurityNumber() {return securityNumber;}

    public void setSecurityNumber(String SecurityNumber) {this.securityNumber = SecurityNumber;}

    public String getAddress() {return address;}

    public void setAddress(String Address) {this.address = address;}

    public int getSalary() {return salary;}

    public void setSalary(int Salary) {this.salary = salary;}

    public String getPosition() {return position;}

    public void setPosition(String Position) {this.position = position;}

    @Override
    public String toString() {
        return "Staff{" +
                "StaffId=" + staffId +
                "name=" + name +
                "SecurityNumber=" + securityNumber +
                "Address=" + address +
                "Salary=" + salary +
                "Position=" + position +
                '}';
    }
}
