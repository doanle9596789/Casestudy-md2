package model;

public class Student extends Center{
    private double mediumScore;

    public Student() {
    }

    public Student(String id, String name, String age, String phoneNumber, String email, String address,double mediumScore) {
        super(id, name, age, phoneNumber, email, address);
        this.mediumScore=mediumScore;
    }


    public double getMediumScore() {
        return mediumScore;
    }

    public void setMediumScore(double mediumScore) {
        this.mediumScore = mediumScore;
    }

    @Override
    public String toString() {
        return "Student:" + super.toString()+","+
                "mediumScore=" + mediumScore +
                "\n " ;
    }
}
