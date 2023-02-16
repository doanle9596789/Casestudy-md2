package model;

import java.io.Serializable;

public class Lecturers extends Center implements Serializable {
    private double basicsalary;
    private double bonus;
    private double fines;

    public Lecturers() {
    }

    public Lecturers(int id, String name, int tuoi, int phonenumber, String email, String address, double basicsalary, double bonus, double fines) {
        super(id, name, tuoi, phonenumber, email, address);
        this.basicsalary = basicsalary;
        this.bonus = bonus;
        this.fines = fines;
    }

    public double getBasicsalary() {
        return basicsalary;
    }

    public void setBasicsalary(double basicsalary) {
        this.basicsalary = basicsalary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getFines() {
        return fines;
    }

    public void setFines(double fines) {
        this.fines= fines;
    }

    @Override
    public String toString() {
        return "Lecturers{" + "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", phonenumber=" + getPhonenumber() +
                ", email='" + getEmail() + '\'' +
                ", address='" + getAddress() + '\'' +
                "basicsalary=" + basicsalary +
                ", bonus=" + bonus +
                ", fine=" + fines +"\n"+
                "} " ;
    }
}
