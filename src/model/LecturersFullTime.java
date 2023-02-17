package model;


import view.Menu;

public class LecturersFullTime extends Center {
    private double basicsalary;
    private double bonus;
    private double fines;

    public LecturersFullTime() {
    }

    public LecturersFullTime(String id, String name, String age, String phonenumber, String email, String address, double basicsalary, double bonus, double fines) {
        super(id, name, age, phonenumber, email, address);
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
        this.fines = fines;
    }

    @Override
    public String toString() {
        return "LecturersFullTime{" +
                "basicsalary=" + basicsalary +
                ", bonus=" + bonus +
                ", fines=" + fines +
                "} " + super.toString();
    }
}
