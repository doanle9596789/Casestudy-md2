package codegym;

import java.io.Serializable;

public class Lecturers extends Center implements Serializable {
    private double basicsalary;
    private double bonus;
    private double fine;

    public Lecturers () {
    }

    public Lecturers(double basicsalary, double bonus, double fine) {
        this.basicsalary = basicsalary;
        this.bonus = bonus;
        this.fine = fine;
    }

    public Lecturers(int id, String name, int tuoi, int phonenumber, String email, String address, double basicsalary, double bonus, double fine) {
        super(id, name, tuoi, phonenumber, email, address);
        this.basicsalary = basicsalary;
        this.bonus = bonus;
        this.fine = fine;
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

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }
}
