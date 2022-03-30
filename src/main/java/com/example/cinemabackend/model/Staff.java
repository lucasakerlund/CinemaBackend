package com.example.cinemabackend.model;

public class Staff {
    private int StaffId;
    private String Name;
    private String SecurityNumber;
    private String Address;
    private int Salary;
    private String Position;

    public Staff (int StaffId, String Name, String SecurityNumber, String Address, int Salary, String Position) {
        this.StaffId = StaffId;
        this.Name = Name;
        this.SecurityNumber = SecurityNumber;
        this.Address = Address;
        this.Salary = Salary;
        this.Position = Position;
    }

    public int getStaffId() {return StaffId;}

    public void setStaffId(int Staffid) {this.StaffId = Staffid;}

    public String getName() {return Name;}

    public void setName (String Name) {this.Name = Name;}

    public String getSecurityNumber() {return SecurityNumber;}

    public void setSecurityNumber(String SecurityNumber) {this.SecurityNumber = SecurityNumber;}

    public String getAddress() {return Address;}

    public void setAddress(String Address) {this.Address = Address;}

    public int getSalary() {return Salary;}

    public void setSalary(int Salary) {this.Salary = Salary;}

    public String getPosition() {return Position;}

    public void setPosition(String Position) {this.Position = Position;}

    @Override
    public String toString() {
        return "Staff{" +
                "StaffId=" + StaffId +
                "Name=" + Name +
                "SecurityNumber=" + SecurityNumber +
                "Address=" + Address +
                "Salary=" + Salary +
                "Position=" + Position +
                '}';
    }
}
