package model;

import java.io.Serializable;

public class LecturersPartTime extends Center {
    private double hourlySalary;
    private double workingHours;

    public LecturersPartTime() {
    }

    public LecturersPartTime(String id, String name, String age, String phonenumber, String email, String address, double hourlySalary, double workingHours) {
        super(id, name, age, phonenumber, email, address);
        this.hourlySalary = hourlySalary;
        this.workingHours = workingHours;
    }

    public double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public double getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(double workingHours) {
        this.workingHours = workingHours;
    }

    @Override
    public String toString() {
        return "LecturersPartTime{" +
                "hourlySalary=" + hourlySalary +
                ", workingHours=" + workingHours +
                "} " + super.toString();
    }
}
