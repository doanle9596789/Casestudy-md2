package model;


import view.Menu;

public class LecturersFullTime extends Center {
    private double basicSalary;
    private double bonus;
    private double fines;

    public LecturersFullTime() {
    }

    public LecturersFullTime(String id, String name, String age, String phoneNumber, String email, String address, double basicSalary, double bonus, double fines) {
        super(id, name, age, phoneNumber, email, address);
        this.basicSalary = basicSalary;
        this.bonus = bonus;
        this.fines = fines;
    }

    public double getBasicsalary() {
        return basicSalary;
    }

    public void setBasicsalary(double basicSalary) {
        this.basicSalary = basicSalary;
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
        return "LecturersFullTime:" + super.toString()+","+
                "basicsalary=" + basicSalary +
                ", bonus=" + bonus +
                ", fines=" + fines +
                "\n ";
    }
}
